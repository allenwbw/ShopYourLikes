package com.ucla.shopyourlikes.payload;

import javax.validation.constraints.NotBlank;

public class ConnexityCreateLinkResponse {

    private String originalUrl;
    private String matchType;
    private float ecpc;
    private Integer publisherId;
    private String link;

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

    public float getEcpc() {
        return ecpc;
    }

    public void setEcpc(float ecpc) {
        this.ecpc = ecpc;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
