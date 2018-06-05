package com.ucla.shopyourlikes.payload.internal;

/**
 * This class contains all information about the EcpcResponseItem object,including all the getters and setters.
 */
public class EcpcResponseItem {

    private String originalUrl;
    private Integer ecpc;

    public String getOriginalUrl() { return originalUrl; }

    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }

    public Integer getEcpc() { return ecpc; }

    public void setEcpc(Integer ecpc) { this.ecpc = ecpc; }
}
