package com.ucla.shopyourlikes.testUtils;


import com.ucla.shopyourlikes.model.MerchantHost;
import com.ucla.shopyourlikes.util.Utils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static org.junit.Assert.*;

public class testUtilsClass {

    @Test
    public void testsqlDateString() {
        Date date = new Date();
        date.setTime(1100);
        String i  = Utils.sqlDateString(date);

        assertEquals(i,Utils.sqlDateString(date));
    }

    @Test
    public void testExtractHash() {
        String i = Utils.extractHash("");
        assertEquals("", i);

        String j =  Utils.extractHash("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");
        assertEquals("e8eeb2331f462b9d",j);
    }

    @Test(expected = IndexOutOfBoundsException.class )
    public void testExtractHash_invalidUrl() {
        String i = Utils.extractHash("www");
        assertEquals("dd", i);
    }

    @Test
    public void testExtractHost() {
        MerchantHost merchantHost = Utils.extractHost("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");

        assertEquals("shopyourlikes",merchantHost.getMerchantDomain());
        assertEquals("com",merchantHost.getMerchantTld());
    }

    @Test(expected = NullPointerException.class)
    public void testExtractHost_Unsupported() {
        MerchantHost merchantHost = Utils.extractHost("htt:/wwwshopyourlikescom");
    }

    @Test
    public void testEncodeUrl() throws UnsupportedEncodingException {
        assertEquals("1",Utils.encodeUrl("1"));
    }
}
