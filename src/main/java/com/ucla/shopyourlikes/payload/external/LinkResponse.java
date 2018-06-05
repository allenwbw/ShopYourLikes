package com.ucla.shopyourlikes.payload.external;

import java.time.Instant;

/**
 * This class contains all information about the LinkResponse object,including all the getters and setters.
 */
public class LinkResponse {
    private Integer userId;
    private String hash;
    private String creationDate;
    private Integer redirects;
    private Float earnings;
    private Integer ecpc;
    private String igImageUrl;
    private String originalUrl;
    private String name;
    private String merchantName;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getRedirects() {
        return redirects;
    }

    public void setRedirects(Integer redirects) {
        this.redirects = redirects;
    }

    public Float getEarnings() {
        return earnings;
    }

    public void setEarnings(Float earnings) {
        this.earnings = earnings;
    }

    public Integer getEcpc() {
        return ecpc;
    }

    public void setEcpc(Integer ecpc) {
        this.ecpc = ecpc;
    }

    public String getIgImageUrl() {
        return igImageUrl;
    }

    public void setIgImageUrl(String igImageUrl) {
        this.igImageUrl = igImageUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantName() { return merchantName; }

    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
}
