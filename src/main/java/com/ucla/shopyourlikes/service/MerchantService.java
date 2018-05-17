package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.payload.internal.ActiveMerchantResponse;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import com.ucla.shopyourlikes.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
        Merchant nullMerchant = new Merchant();
        nullMerchant.setMerchantId(-1);
        nullMerchant.setMerchantName("N/A");
        merchantRepository.save(nullMerchant);
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
