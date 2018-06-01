package com.ucla.shopyourlikes.payload.internal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testGetMerchantsResponse {

    private GetMerchantsResponse getMerchantsResponse;

    @Before
    public void setUp() {
        this.getMerchantsResponse = new GetMerchantsResponse();
    }

    @Test
    public void testGetMerchantsResponsObjCreation() {
        MerchantResponseItem merchantResponseItem = new MerchantResponseItem();
        merchantResponseItem.setMerchantId(1);
        List<MerchantResponseItem> merchantResponseItems = new ArrayList<>();
        merchantResponseItems.add(merchantResponseItem);
        this.getMerchantsResponse.setActiveMerchantsResponse(merchantResponseItems);

        assertEquals(new Integer(1),this.getMerchantsResponse.getActiveMerchantsResponse().get(0).getMerchantId());
        assertEquals(1,this.getMerchantsResponse.getActiveMerchantsResponse().size());
    }
}
