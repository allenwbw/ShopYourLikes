package com.ucla.shopyourlikes.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SylLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer user_id;
    private String hash;
    private Integer redirects;
    private Float earnings;
    private Float epc;
    private String ig_image_url;
    private String original_url;
    private Integer merchant_id;
    private String name;

    public Integer getUserId() {return user_id;}
    public String getHash() {return hash;}
    public Integer getRedirects() {return redirects;}
    public Float getEarnings(){return earnings;}
    public Float getEpc() {return epc;}
    public String getIgImageUrl() {return  ig_image_url;}
    public String getOriginalUrl() {return original_url;}
    public Integer getMerchantId() {return merchant_id;}
    public String getName() {return name;}

}
