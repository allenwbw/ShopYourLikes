package com.ucla.shopyourlikes.Utils;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.LinkId;

import com.ucla.shopyourlikes.model.Merchant;
import com.ucla.shopyourlikes.payload.external.EcpcResponse;
import com.ucla.shopyourlikes.payload.external.LinkResponse;
import com.ucla.shopyourlikes.payload.internal.EcpcResponseItem;
import com.ucla.shopyourlikes.payload.internal.GenerateLinkResponse;
import com.ucla.shopyourlikes.payload.internal.GetEcpcResponse;
import com.ucla.shopyourlikes.payload.internal.MerchantResponseItem;
import com.ucla.shopyourlikes.util.ModelMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class testModelMapper {

    @Test
    public void testMapLinkToLinkResponse() {
        Link link = new Link();
        LinkId linkId = new LinkId();
        linkId.setHash("aka");
        linkId.setUserId(1);
        link.setLinkId(linkId);
        link.setCreationDate("11:00am");
        link.setEarnings(1f);
        link.setRedirects(2);
        link.setEcpc(5);
        link.setIgImageUrl("www.macys.com");
        link.setOriginalUrl("www.targets.com");
        link.setMerchantName("ucla");
        link.setName("shop");
        link.setUrl("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");

        LinkResponse linkResponse = ModelMapper.mapLinkToLinkResponse(link);

        assertEquals(link.getLinkId().getHash(),linkResponse.getHash());
        assertEquals(link.getLinkId().getUserId(),linkResponse.getUserId());
        assertEquals(link.getCreationDate(),linkResponse.getCreationDate());
        assertEquals(link.getEarnings(),linkResponse.getEarnings());
        assertEquals(link.getRedirects(), linkResponse.getRedirects());
        assertEquals(link.getEcpc(),linkResponse.getEcpc());
        assertEquals(link.getIgImageUrl(),linkResponse.getIgImageUrl());
        assertEquals(link.getOriginalUrl(),linkResponse.getOriginalUrl());
        assertEquals(link.getMerchantName(), linkResponse.getMerchantName());
        assertEquals(link.getName(), linkResponse.getName());
        assertEquals(link.getUrl(), linkResponse.getLink());
    }

    @Test
    public void testMapGenerateLinkResponse() {

        GenerateLinkResponse generateLinkResponse = new GenerateLinkResponse();
        generateLinkResponse.setEcpc(1);
        generateLinkResponse.setOriginalUrl("www.google.com");
        generateLinkResponse.setLink("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");

        Merchant merchant = new Merchant();
        merchant.setMerchantName("paypal");
        merchant.setMerchantId(2);

        Link link = ModelMapper.mapGenerateLinkRepsonse(generateLinkResponse,1,merchant);
        String date = link.getCreationDate();

        assertEquals(date,link.getCreationDate());
        assertEquals(generateLinkResponse.getEcpc(),link.getEcpc());
        assertEquals(new Float(0.0f),link.getEarnings());
        assertEquals(generateLinkResponse.getOriginalUrl(),link.getOriginalUrl());
        assertEquals("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=1",link.getUrl());
        assertEquals(new Integer(1),link.getUserId());
        assertEquals(new Integer(0),link.getRedirects());
        assertEquals(merchant.getMerchantName(), link.getMerchantName());
        assertEquals(merchant.getMerchantId(), link.getMerchantId());
    }

    @Test
    public void testMapGenerateLinkResponse_nullMerchant() {
        GenerateLinkResponse generateLinkResponse = new GenerateLinkResponse();
        generateLinkResponse.setEcpc(1);
        generateLinkResponse.setOriginalUrl("www.google.com");
        generateLinkResponse.setLink("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");

        Link link = ModelMapper.mapGenerateLinkRepsonse(generateLinkResponse,1,null);

        assertEquals("N/A", link.getMerchantName());
        assertEquals(new Integer(-1), link.getMerchantId());
    }

    @Test
    public void testMapActiveMerchantResponse() {
        MerchantResponseItem merchantResponseItem = new MerchantResponseItem();
        merchantResponseItem.setMerchantId(1);
        merchantResponseItem.setMerchantName("ucla");
        merchantResponseItem.setMerchantUrl("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");

        Merchant merchant = ModelMapper.mapActiveMerchantResponse(merchantResponseItem);

        assertEquals(merchantResponseItem.getMerchantId(), merchant.getMerchantId());
        assertEquals(merchantResponseItem.getMerchantName(),merchant.getMerchantName());
        assertEquals("shopyourlikes",merchant.getMerchantHost().getMerchantDomain());
    }

    @Test
    public void testMapEcpcResponse() {
        GetEcpcResponse getEcpcResponse = new GetEcpcResponse();
        EcpcResponseItem ecpcResponseItem = new EcpcResponseItem();
        ecpcResponseItem.setOriginalUrl("www");
        ecpcResponseItem.setEcpc(1);
        List<EcpcResponseItem> list = new ArrayList<>();
        list.add(ecpcResponseItem);
        getEcpcResponse.setEcpcList(list);

        EcpcResponse ecpcResponse = ModelMapper.mapEcpcResponse(getEcpcResponse);

        assertEquals(getEcpcResponse.getEcpcList().get(0).getOriginalUrl(), ecpcResponse.getUrl());
        assertEquals(getEcpcResponse.getEcpcList().get(0).getEcpc(), ecpcResponse.getEcpc());

    }
}
