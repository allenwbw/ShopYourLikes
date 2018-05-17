package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.model.MerchantHost;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.*;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.util.AppConstants;
import com.ucla.shopyourlikes.util.ModelMapper;
import com.ucla.shopyourlikes.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import  org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LinksService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ConnexityService connexityService;

    private static final Logger logger = LoggerFactory.getLogger(LinksService.class);
    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

    public PagedResponse<LinkResponse> getAllLinks(Object currentUser, int page, int size){
        validatePageNumberAndSize(page, size);
        User user = userRepository.findByUserId(Integer.parseInt(currentUser.toString()));

        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "creationDate");
        Page<Link> links = linkRepository.findByLinkIdUserId(user.getUserId(), pageable);
        if (links.getNumberOfElements() == 0){
            return new PagedResponse<>(Collections.emptyList(), links.getNumber(),
                    links.getSize(), links.getTotalElements(), links.getTotalPages(), links.isLast());
        }

        List<LinkResponse> linkResponses = links.map(link -> {
            return ModelMapper.mapLinkToLinkResponse(link);
        }).getContent();

        return new PagedResponse<>(linkResponses, links.getNumber(),
                links.getSize(), links.getTotalElements(), links.getTotalPages(), links.isLast());

    }

    public CreateLinksResponse createLinks(Object currentUser, List<String> urls) {

        User user = userRepository.findByUserId(Integer.parseInt(currentUser.toString()));

        if(user == null)
            return null;

        List<GenerateLinkResponse> sylLinks = connexityService.createLinks(user, urls);
        List<LinkResponse> sylRes = new ArrayList<LinkResponse>();

        for(GenerateLinkResponse res : sylLinks)
        {
            MerchantHost host = Utils.extractHost(res.getOriginalUrl());

            Merchant merchant = merchantRepository.getMerchantByMerchantHost(host);

            Link link = ModelMapper.mapGenerateLinkRepsonse(res, user.getUserId(), merchant);

            LinkResponse linkRes = ModelMapper.mapLinkToLinkResponse(link);
            sylRes.add(linkRes);

            linkRepository.save(link);
        }
        linkRepository.flush();

        CreateLinksResponse createLinksResponse = new CreateLinksResponse(sylRes);
        return createLinksResponse;

    }
}