package com.ucla.shopyourlikes.payload.external;


/**
 * This class contains all information about the EcpcResponse object,including all the getters and setters.
 */
public class EcpcResponse {

    private String url;
    private Integer ecpc;

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public Integer getEcpc() { return ecpc; }

    public void setEcpc(Integer ecpc) { this.ecpc = ecpc; }
}
