package com.ucla.shopyourlikes.util;

import com.ucla.shopyourlikes.model.MerchantHost;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String sqlDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
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

        if(l < 2)
            return null;

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
}
