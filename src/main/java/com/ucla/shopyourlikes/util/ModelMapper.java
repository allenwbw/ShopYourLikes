package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.payload.external.EcpcResponse;
import com.ucla.shopyourlikes.payload.internal.MerchantResponseItem;
import com.ucla.shopyourlikes.payload.external.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.internal.EcpcResponseItem;
import com.ucla.shopyourlikes.payload.internal.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.external.LinkResponse;
import com.ucla.shopyourlikes.payload.internal.GetEcpcResponse;

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
        Integer timestamp = Utils.unixTime();
        link.setCreationDate(timestamp);
        link.setLastUpdated(timestamp);
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

    public static Merchant mapActiveMerchantResponse(MerchantResponseItem response) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(response.getMerchantId());
        merchant.setMerchantName(response.getMerchantName());
        merchant.setMerchantHost(Utils.extractHost(response.getMerchantUrl()));
        return merchant;
    }

    public static EcpcResponse mapEcpcResponse(GetEcpcResponse response) {
        EcpcResponse ecpcResponse = new EcpcResponse();
        EcpcResponseItem item = response.getEcpcList().get(0);
        ecpcResponse.setUrl(item.getOriginalUrl());
        ecpcResponse.setEcpc(item.getEcpc());
        return ecpcResponse;
    }
}
