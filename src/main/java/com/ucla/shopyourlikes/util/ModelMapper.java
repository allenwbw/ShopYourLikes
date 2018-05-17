package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.payload.ActiveMerchantResponse;
import com.ucla.shopyourlikes.payload.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

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
        linkResponse.setLink(link.getUrl());
        return linkResponse;
    }

    public static CreateLinksResponse mapCreateLinkResponse(Object obj){
        CreateLinksResponse createLinksResponse = new CreateLinksResponse();
        return createLinksResponse;
    }

    public static Link mapGenerateLinkRepsonse(GenerateLinkResponse generateLinkResponse, Integer userId, Merchant merchant) {
        Link link = new Link();
        link.setCreationDate(Utils.sqlDateString(new Date()));
        link.setEcpc(generateLinkResponse.getEcpc());
        link.setEarnings(0.0f);
        link.setOriginalUrl(generateLinkResponse.getOriginalUrl());
        link.setUrl(generateLinkResponse.getLink());
        link.setUserId(userId);
        link.setRedirects(0);
        if(merchant != null) {
            link.setMerchantName(merchant.getMerchantName());
            link.setMerchantId(merchant.getMerchantId());
        }
        //link.setMerchant(merchant);
        return link;
    }

    public static Merchant mapActiveMerchantResponse(ActiveMerchantResponse response) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(response.getMerchantId());
        merchant.setMerchantName(response.getMerchantName());
        merchant.setMerchantHost(Utils.extractHost(response.getMerchantUrl()));
        return merchant;
    }
}
