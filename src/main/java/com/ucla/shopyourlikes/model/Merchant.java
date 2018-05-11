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


@Entity
@Table(name = "merchants")
public class Merchant{
    @Id
    @NotBlank
    @Column(name = "merchant_id")
    private Integer merchantId;

    @NotNull
    @Size(max = 50)
    @Column(name = "merchant_name")
    private String merchantName;

    public Merchant() {

    }

    public Merchant(Integer merchantId, String merchantName){
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }

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
}
