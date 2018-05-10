package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.payload.CreateLinkResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

import java.time.Instant;

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

    public static CreateLinkResponse mapCreateLinkResponse(Object obj){
        CreateLinkResponse createLinkResponse = new CreateLinkResponse();
        return createLinkResponse;
    }
}
