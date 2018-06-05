package com.ucla.shopyourlikes.payload.internal;

import java.util.List;

/**
 * This class contains all information about the GetMerchantsResponse object,including all the getters and setters.
 */
public class GetMerchantsResponse {

    private List<MerchantResponseItem> activeMerchantsResponse;

    public List<MerchantResponseItem> getActiveMerchantsResponse() {
        return activeMerchantsResponse;
    }

    public void setActiveMerchantsResponse(List<MerchantResponseItem> activeMerchantsResponse) {
        this.activeMerchantsResponse = activeMerchantsResponse;
    }
}
