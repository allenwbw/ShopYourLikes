package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.payload.internal.MerchantResponseItem;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import com.ucla.shopyourlikes.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * This class contains all the merchant service calls.
 */
@Service
public class MerchantService {
    @Autowired
    protected MerchantRepository merchantRepository;

    @Autowired
    protected ConnexityService connexityService;

    /**
     * Initialization for the merchant repository
     */
    @PostConstruct
    private void init()
    {
        Merchant nullMerchant = new Merchant();
        nullMerchant.setMerchantId(-1);
        nullMerchant.setMerchantName("N/A");
        merchantRepository.save(nullMerchant);
        List<MerchantResponseItem> merchants = connexityService.getMerchants("US");
        for(MerchantResponseItem m : merchants)
        {
            Merchant merchant = ModelMapper.mapActiveMerchantResponse(m);
            merchantRepository.save(merchant);
        }
        merchantRepository.flush();
    }

    /**
     *
     * @param merchantId
     * @return the merchant
     */

    public Merchant getMerchantById(Integer merchantId)
    {
        if (merchantId == null) return null;
        return merchantRepository.getByMerchantId(merchantId);
    }
}
