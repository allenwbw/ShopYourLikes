package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Merchant getByMerchantId(Integer merchantId);
}
