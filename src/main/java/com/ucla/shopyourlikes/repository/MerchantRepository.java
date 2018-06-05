package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.model.MerchantHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;

/**
 * MerchantRepository that provides client to find the merchant
 */
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    /**
     *
     * @param merchantId
     * @return the merchant that matches the param
     */
    Merchant getByMerchantId(Integer merchantId);

    /**
     *
     * @param host
     * @return the merchant that matches the param
     */
    Merchant getMerchantByMerchantHost(MerchantHost host);

    /**
     * delete all in Batch
     */
    void deleteAllInBatch();
}
