package com.ucla.shopyourlikes.payload.internal;

import com.ucla.shopyourlikes.payload.internal.ActiveMerchantResponse;

import java.util.List;

public class GetMerchantsResponse {

    private List<ActiveMerchantResponse> activeMerchantsResponse;

    public List<ActiveMerchantResponse> getActiveMerchantsResponse() {
        return activeMerchantsResponse;
    }

}
