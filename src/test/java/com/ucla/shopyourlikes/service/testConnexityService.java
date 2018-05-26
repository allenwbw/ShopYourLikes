package com.ucla.shopyourlikes.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.internal.*;
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

    private ConnexityService connexityService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        connexityService = new ConnexityService();
    }

    @Test
    public void testCreateLinks() {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        List<String> testUrls =  new ArrayList<>();
        testUrls.add("www.macys.com");
        List<GenerateLinkResponse> createLinks =  connexityService.createLinks(user,testUrls);
        int ecpc =  createLinks.get(0).getEcpc();
        String url =  createLinks.get(0).getOriginalUrl();
        String type =  createLinks.get(0).getMatchType();
        String userId = createLinks.get(0).getPublisherId();
        String syl_url =  createLinks.get(0).getLink();

        assertNotNull(createLinks);
        assertEquals("http://www.macys.com",url);
        assertEquals(5,ecpc);
        assertEquals("628626",userId);
        assertEquals("PAGE_CPC",type);
        assertEquals("http://go.shopyourlikes.com/pi/e8eeb2b83bc433c0a5762331f4d80ba113362b9d?afId=628626&afCreativeId=2993",syl_url);
    }

    @Test
    public void testCreateLinksThrowHttpClientErrorException() throws HttpClientErrorException {
        User user = new User();
        user.setUserId(anyInt());
        user.setApiKey(anyString());
        List<String> testUrls =  new ArrayList<>();
        testUrls.add("www.macys.com");
        connexityService.createLinks(user,testUrls);
    }
    @Test
    public void testGetMerchants() {
        String reqUrl = "http://api.shopyourlikes.com/api/activeMerchants?publisherId=628626&apiKey=7438a399d83eceffef422e5563a94401&countryCode=US";
        GenerateLinkResponse response = new GenerateLinkResponse();
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);
        assertNotNull(response);
    }

    @Test
    public void testGetMerchantsThrowHttpClientErrorException() throws HttpClientErrorException {
        connexityService.getMerchants(anyString());
    }

    @Test
    public void testGetMerchantsBadRequestException() {
        List<MerchantResponseItem> merchantResponseItems = connexityService.getMerchants(null);
        assertEquals(new ArrayList<>(), merchantResponseItems);
    }

    @Test
    public void testGetEcpc() {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        String url =  "www.macys.com";
        GetEcpcResponse getEcpc = connexityService.getEcpc(user,url);
        List<EcpcResponseItem> ecpcResponseItems = getEcpc.getEcpcList();
        int result = ecpcResponseItems.get(0).getEcpc();
        assertNotNull(getEcpc);
        assertEquals(5,result);
        assertEquals("http://www.macys.com",ecpcResponseItems.get(0).getOriginalUrl());
    }

    @Test
    public void testGetEcpcThrowHttpClientErrorException() throws HttpClientErrorException {
        User user = new User();
        user.setUserId(anyInt());
        user.setApiKey(anyString());
        connexityService.getEcpc(user,anyString());
    }

}
