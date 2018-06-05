package com.ucla.shopyourlikes.payload.internal;

import java.util.List;

/**
 * This class contains all information about the GetEcpcResponse object,including all the getters and setters.
 */
public class GetEcpcResponse {

    private Integer publisherId;
    private List<EcpcResponseItem> ecpcList;

    public Integer getPublisherId() { return publisherId; }

    public void setPublisherId(Integer publisherId) { this.publisherId = publisherId; }

    public List<EcpcResponseItem> getEcpcList() { return ecpcList; }

    public void setEcpcList(List<EcpcResponseItem> ecpcList) { this.ecpcList = ecpcList; }
}
