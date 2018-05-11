package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.payload.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

public class ModelMapper {
    public static LinkResponse mapLinkToLinkResponse(Link link){
        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setUserId(link.getLinkId().getUserId());
        linkResponse.setHash(link.getLinkId().getHash());
        linkResponse.setCreationDate(link.getCreationDate());
        linkResponse.setEarnings(link.getEarnings());
        linkResponse.setRedirects(link.getRedirects());
        linkResponse.setEpc(link.getEpc());
        linkResponse.setIgImageUrl(link.getIgImageUrl());
        linkResponse.setOriginalUrl(link.getOriginalUrl());
        linkResponse.setMerchantId(link.getMerchantId());
        linkResponse.setName(link.getName());
        return linkResponse;
    }

    public static CreateLinksResponse mapCreateLinkResponse(Object obj){
        CreateLinksResponse createLinkResponse = new CreateLinksResponse();
        return createLinkResponse;
    }

    public static String extractHash(String url) {
        if(url.isEmpty()) return "";
        return url.substring(url.lastIndexOf("/") +1, url.indexOf("?"));
    }
}
