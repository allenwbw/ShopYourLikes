package com.ucla.shopyourlikes.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.internal.ActiveMerchantResponse;
import com.ucla.shopyourlikes.payload.internal.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.internal.GetMerchantsResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

// TODO: will add more testcase
public class testConnexityService {

    @Mock
    private ConnexityService connexityService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation() {
        assertNotNull(connexityService);
    }

    @Test
    public void testCreateLinks() {
        User user = new User();
        user.setUserId(1000);
        user.setApiKey("10000");
        List<String> testUrls =  new ArrayList<>();
        testUrls.add("www.macys.com");
        List<GenerateLinkResponse> linkResponses =  new ArrayList<>();
        GenerateLinkResponse generateLinkResponse = new GenerateLinkResponse();
        generateLinkResponse.setEcpc(2);
        generateLinkResponse.setLink("www.targets.com");
        generateLinkResponse.setMatchType("food");
        generateLinkResponse.setMerchantName("targets");
        generateLinkResponse.setPublisherId("1000");
        generateLinkResponse.setOriginalUrl("www.target.com");
        linkResponses.add(generateLinkResponse);

        when(connexityService.createLinks(user, testUrls)).thenReturn(linkResponses);
        assertEquals(linkResponses,connexityService.createLinks(user,testUrls));
    }

    @Test
    public void testCreateLinksThrowUnsupportedEncodingException() {
        User user = new User();
        user.setUserId(1000);
        user.setApiKey("10000");
        List<String> testUrls =  new ArrayList<>();
        testUrls.add("d//////d///dff||Ddksklddddldldldlsdls");
        given(connexityService.createLinks(user,testUrls)).willAnswer( invocation -> { throw new UnsupportedEncodingException(); });
    }

    @Test(expected = HttpClientErrorException.class)
    public void testCreateLinksThrowHttpClientErrorException() {
        String reqUrl = "http://api.shopyourlikes.com/api/link/generate?url=http%3A%2F%2Fwww.shopzilla.com&publisherId=6dd626&apiKey=743dd99d83eceffef422e5563a94401&afCampaignId=group1";
        GenerateLinkResponse response = new GenerateLinkResponse();
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);

    }
    @Test
    public void testGetMerchants() throws UnsupportedEncodingException {
        ActiveMerchantResponse activeMerchantResponse = new ActiveMerchantResponse();
        activeMerchantResponse.setMerchantId(1000);
        activeMerchantResponse.setMerchantName("paypal");
        activeMerchantResponse.setMerchantUrl("www.paypal.com");
        List<ActiveMerchantResponse> activeMerchantResponseList =  new ArrayList<>();
        activeMerchantResponseList.add(activeMerchantResponse);

        GetMerchantsResponse getMerchantsResponse = new GetMerchantsResponse();
        getMerchantsResponse.getActiveMerchantsResponse();

        when(connexityService.getMerchants("1000")).thenReturn(activeMerchantResponseList);
        assertEquals(activeMerchantResponseList,connexityService.getMerchants("1000"));
    }

    @Test(expected = HttpClientErrorException.class)
    public void testGetMerchantsThrowHttpClientErrorException() {
        String reqUrl = "http://api.shopyourlikes.com/api/activeMerchants?publisherId=636dd&apiKey=7438ffff9d83eceffef422e5563a94401&countryCode=LSLS";
        GenerateLinkResponse response = new GenerateLinkResponse();
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);

    }


}
