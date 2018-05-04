package com.ucla.ShopYourLikes.util;

import com.ucla.ShopYourLikes.model.Link;
import com.ucla.ShopYourLikes.model.LinkId;
import com.ucla.ShopYourLikes.payload.LinkResponse;

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
}
