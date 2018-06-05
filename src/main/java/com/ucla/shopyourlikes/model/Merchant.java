package com.ucla.shopyourlikes.model;
//import com.ucla.ShopYourLikes.model.audit.DateAudit;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * This class contains all information about the merchant object, including all the getters and setters.
 */
@Entity
@Table(name = "merchants")
public class Merchant{

    @Id
    @Column(name = "merchant_id")
    private Integer merchantId;

    @NotBlank
    @NotNull
    @Column(name = "merchant_name")
    private String merchantName;

    @Embedded
    private MerchantHost merchantHost;

    public Merchant(){this.merchantHost = new MerchantHost();}

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer id) {
        this.merchantId = id;
    }

    public String getMerchantName(){
        return merchantName;
    }

    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }

    public MerchantHost getMerchantHost() { return merchantHost; }

    public void setMerchantHost(MerchantHost merchantHost) { this.merchantHost = merchantHost; }


}
