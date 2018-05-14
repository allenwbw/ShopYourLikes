package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.model.MerchantHost;
import com.ucla.shopyourlikes.payload.ActiveMerchantResponse;
import com.ucla.shopyourlikes.payload.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class ModelMapper {
    public static LinkResponse mapLinkToLinkResponse(Link link){
        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setUserId(link.getLinkId().getUserId());
        linkResponse.setHash(link.getLinkId().getHash());
        linkResponse.setCreationDate(link.getCreationDate());
        linkResponse.setEarnings(link.getEarnings());
        linkResponse.setRedirects(link.getRedirects());
        linkResponse.setEcpc(link.getEcpc());
        linkResponse.setIgImageUrl(link.getIgImageUrl());
        linkResponse.setOriginalUrl(link.getOriginalUrl());
        linkResponse.setMerchantName(link.getMerchantName());
        linkResponse.setName(link.getName());
        return linkResponse;
    }

    public static CreateLinksResponse mapCreateLinkResponse(Object obj){
        CreateLinksResponse createLinksResponse = new CreateLinksResponse();
        return createLinksResponse;
    }

    public static String sqlDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static Link mapGenerateLinkRepsonse(GenerateLinkResponse generateLinkResponse, Integer userId, Merchant merchant) {
        Link link = new Link();
        link.setCreationDate(sqlDateString(new Date()));
        link.setEcpc(generateLinkResponse.getEcpc());
        link.setEarnings(0.0f);
        link.setOriginalUrl(generateLinkResponse.getOriginalUrl());
        link.setUrl(generateLinkResponse.getLink());
        link.setUserId(userId);
        link.setRedirects(0);
        if(merchant != null)
            link.setMerchant(merchant);
        return link;
    }

    public static String extractHash(String url) {
        if(url.isEmpty()) return "";
        return url.substring(url.lastIndexOf("/") +1, url.indexOf("?"));
    }

    public static MerchantHost extractHost(String url) {

        try {
            url = URLDecoder.decode(url, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return null;
        }

        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            return null;
        }

        String[] h = uri.getHost().toLowerCase().split("\\.");
        int l = h.length;

        MerchantHost host = new MerchantHost();
        host.setMerchantDomain(h[l-2]);
        host.setMerchantTld(h[l-1]);

        System.out.println(host.getMerchantDomain());
        System.out.println(host.getMerchantTld());

        return host;
    }

    public static String encodeUrl(String value) throws UnsupportedEncodingException{
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    public static Merchant mapActiveMerchantResponse(ActiveMerchantResponse response) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(response.getMerchantId());
        merchant.setMerchantName(response.getMerchantName());
        merchant.setMerchantHost(extractHost(response.getMerchantUrl()));
        return merchant;
    }
}
