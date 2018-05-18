package com.ucla.shopyourlikes.payload.internal;

public class EcpcResponseItem {

    private String originalUrl;
    private Integer ecpc;

    public String getOriginalUrl() { return originalUrl; }

    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }

    public Integer getEcpc() { return ecpc; }

    public void setEcpc(Integer ecpc) { this.ecpc = ecpc; }
}
