package com.ucla.shopyourlikes.payload.internal;

public class GenerateLinkResponse {
    private String originalUrl;
    private String matchType;
    private Integer ecpc;
    private String publisherId;
    private String link;
    private String merchantName;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Integer getEcpc() {
        return ecpc;
    }

    public void setEcpc(Integer ecpc) {
        this.ecpc = ecpc;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMerchantName() { return merchantName; }

    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
}

