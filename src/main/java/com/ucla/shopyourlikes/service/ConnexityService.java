package com.ucla.shopyourlikes.service;

import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.internal.ActiveMerchantResponse;
import com.ucla.shopyourlikes.payload.internal.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.internal.GetMerchantsResponse;
import com.ucla.shopyourlikes.util.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConnexityService {

    private static final Logger logger = LoggerFactory.getLogger(ConnexityService.class);

    @Value("${app.publisherId}")
    private String rootPublisherId;

    @Value("${app.apiKey}")
    private String rootApiKey;

    public List<GenerateLinkResponse> createLinks(User user, List<String> urls) {

        List<GenerateLinkResponse> sylLinks = new ArrayList<>();

        String publisherid = user.getUserId().toString();
        String apiKey = user.getApiKey();

        String baseUrl = "http://api.shopyourlikes.com/api/link/generate?url=";

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        //Add the Jackson Message converter
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);

        for (String url : urls){
            GenerateLinkResponse response = new GenerateLinkResponse();
            String reqUrl;
            try {
                reqUrl = baseUrl + Utils.encodeUrl(url) + "&publisherId=" + publisherid + "&apiKey=" + apiKey;
            } catch (UnsupportedEncodingException e) {
                continue;
            }
            try {
                response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);
            } catch (HttpClientErrorException ce) {
                logger.error("Fail to contact SYL server",ce);
            }
            sylLinks.add(response);
        }

        return sylLinks;
    }

    public List<ActiveMerchantResponse> getMerchants(String countryCode)
    {
        List<ActiveMerchantResponse> merchants = new ArrayList<>();

        String baseUrl = "http://api.shopyourlikes.com/api/activeMerchants";

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        GetMerchantsResponse response = new GetMerchantsResponse();

        String reqUrl = baseUrl + "?publisherId=" + rootPublisherId + "&apiKey=" + rootApiKey + "&countryCode=" + countryCode;

        try {
            response = restTemplate.getForObject(reqUrl, GetMerchantsResponse.class);
        } catch (HttpClientErrorException e) {
            logger.error("Fail to contact SYL server", e);
        }

        return response.getActiveMerchantsResponse();
    }
}
