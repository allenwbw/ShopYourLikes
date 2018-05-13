package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Merchant getByMerchantId(Integer merchantId);

    Merchant getMerchantByMerchantUrl(String url);

    void deleteAllInBatch();
}
