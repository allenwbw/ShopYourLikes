package com.ucla.shopyourlikes.service;

import com.google.common.base.Strings;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.internal.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.internal.GetEcpcResponse;
import com.ucla.shopyourlikes.payload.internal.GetMerchantsResponse;
import com.ucla.shopyourlikes.payload.internal.MerchantResponseItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class includes all the service methods call to the Connexity.
 */
@Service
public class ConnexityService {

    private static final Logger logger = LoggerFactory.getLogger(ConnexityService.class);

    @Value("${app.publisherId}")
    private String rootPublisherId;

    @Value("${app.apiKey}")
    private String rootApiKey;

    /**
     *
     * @param user contains detailed information about the user
     * @param urls  a list of the urls that the user attempts to convert to SYL links
     * @return a list of GenerateLinkResponse that has originalUrl,matchType,
     * ecpc, publisherId,link, merchantName;
     */
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
            reqUrl = baseUrl + url + "&publisherId=" + publisherid + "&apiKey=" + apiKey;
            try {
                response = restTemplate.getForObject(reqUrl, GenerateLinkResponse.class);
            } catch (HttpClientErrorException ce) {
                logger.error("Fail to contact SYL server",ce);
            }
            sylLinks.add(response);
        }

        return sylLinks;
    }

    /**
     *
     * @param countryCode a county code that specify the merchant country
     * @return a list of MerchantResponseItem that contains merchantId ,merchantName, merchantUrl
     */

    public List<MerchantResponseItem> getMerchants(String countryCode) {

        if(Strings.isNullOrEmpty(countryCode)) {
            return new ArrayList<>();
        }

        List<MerchantResponseItem> merchants = new ArrayList<>();

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

    /**
     *
     * @param user contains detailed information about the user
     * @param url  an original url
     * @return a GetEcpcResponse that contains a list of EcpcResponseItem with the userId
     */

    public GetEcpcResponse getEcpc(User user, String url) {
        String baseUrl = "http://api.shopyourlikes.com/api/link/ecpc?url=";

        RestTemplate restTemplate = new RestTemplate();

        GetEcpcResponse response = new GetEcpcResponse();

        String reqUrl = baseUrl + url + "&publisherId=" + user.getUserId() + "&apiKey=" + user.getApiKey();

        try {
            response = restTemplate.getForObject(reqUrl, GetEcpcResponse.class);
        } catch (HttpClientErrorException e) {
            logger.error("Fail to contact SYL server", e);
        }

        return response;
    }
}
