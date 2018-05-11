package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.*;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.util.AppConstants;
import com.ucla.shopyourlikes.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import  org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(LinkService.class);
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
    private String encodeValue(String value) {
        String result = value;
        try {
            result = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("Unsupported encoding",e);
        }
        return result;
    }

    public CreateLinksResponse createLinks(Object currentUser, List<String> urls){
        User user = userRepository.findByUserId(Integer.parseInt(currentUser.toString()));
        List<GenerateLinkResponse> sylLinks = new ArrayList<>();
        String publisherid = user.getUserId().toString();
        String apiKey = user.getApiKey();
        String baseUrl = "http://api.shopyourlikes.com/api/link/generate?url=";
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

//Add the Jackson Message converter
        messageConverters.add(new MappingJackson2HttpMessageConverter());
//Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);
        for (String url : urls){
            GenerateLinkResponse response = new GenerateLinkResponse();
            String reqUrl = baseUrl+encodeValue(url)+"&publisherId="+publisherid+"&apiKey="+apiKey;
            try {
                response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);
            } catch (HttpClientErrorException ce) {
                logger.error("Fail to contact SYL server",ce);
            }
            sylLinks.add(response);
        }
        CreateLinksResponse createLinksResponse = new CreateLinksResponse(sylLinks);
        return createLinksResponse;

    }
}
