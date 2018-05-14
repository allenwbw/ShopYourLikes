package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.ActiveMerchantResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;
import com.ucla.shopyourlikes.payload.PagedResponse;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.util.AppConstants;
import com.ucla.shopyourlikes.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import  org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ConnexityService connexityService;

    @PostConstruct
    private void init()
    {
        List<ActiveMerchantResponse> merchants = connexityService.getMerchants("US");

        for(ActiveMerchantResponse m : merchants)
        {
            Merchant merchant = ModelMapper.mapActiveMerchantResponse(m);
            merchantRepository.save(merchant);
        }
        merchantRepository.flush();
    }

    public Merchant getMerchantById(Integer merchantId)
    {
        return merchantRepository.getByMerchantId(merchantId);
    }
}
