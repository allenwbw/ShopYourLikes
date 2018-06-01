package com.ucla.shopyourlikes.payload.internal;

import java.util.List;

public class GetMerchantsResponse {

    private List<MerchantResponseItem> activeMerchantsResponse;

    public List<MerchantResponseItem> getActiveMerchantsResponse() {
        return activeMerchantsResponse;
    }

    public void setActiveMerchantsResponse(List<MerchantResponseItem> activeMerchantsResponse) {
        this.activeMerchantsResponse = activeMerchantsResponse;
    }
}
