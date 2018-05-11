package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.Link;
<<<<<<< HEAD
import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.payload.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

=======
import com.ucla.shopyourlikes.payload.CreateLinksResponse;
import com.ucla.shopyourlikes.payload.LinkResponse;

>>>>>>> a92e89e25847548b9f22c077a78aca1e2127bd2c
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
        linkResponse.setMerchantId(link.getMerchantId());
        linkResponse.setName(link.getName());
        return linkResponse;
    }

    public static CreateLinksResponse mapCreateLinkResponse(Object obj){
        CreateLinksResponse createLinksResponse = new CreateLinksResponse();
        return createLinksResponse;
    }

    public static String sqlDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        return dateFormat.format(date);
    }

    public static Link mapGenerateLinkRepsonse(GenerateLinkResponse generateLinkResponse, Integer userId) {
        Link link = new Link();
        link.setCreationDate(sqlDateString(new Date()));
        link.setEcpc(generateLinkResponse.getEcpc());
        link.setEarnings(0.0f);
        link.setOriginalUrl(generateLinkResponse.getOriginalUrl());
        link.setUrl(generateLinkResponse.getLink());
        link.setUserId(userId);
        return link;
    }

    public static String extractHash(String url) {
        if(url.isEmpty()) return "";
        return url.substring(url.lastIndexOf("/") +1, url.indexOf("?"));
    }
}
