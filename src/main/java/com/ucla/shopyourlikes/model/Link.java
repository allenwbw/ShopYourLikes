package com.ucla.shopyourlikes.model;
import com.ucla.shopyourlikes.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "links")
public class Link {

    @EmbeddedId
    private LinkId linkId;

    @NotNull
    @Column(columnDefinition = "DATETIME", name = "creation_date")
    private String creationDate;

    @NotNull
    private Integer redirects;

    @NotNull
    private Float earnings;

    @NotNull
    private Float epc;

    @Size(max = 30)
    @Column(name = "ig_image_url")
    private String igImageUrl;

    @NotNull
    @Size(max = 100)
    @Column(name = "original_url")
    private String originalUrl;

    @OneToOne
    private Merchant merchant;

    @Size(max = 30)
    private String name;


    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Link() {
        linkId = new LinkId();
    }

    public LinkId getLinkId() {
        return linkId;
    }

    public void setLinkId(LinkId linkId) {
        this.linkId = linkId;
    }

    public Integer getUserId() {
        return linkId.getUserId();
    }

    public void setUserId(Integer userId){
        linkId.setUserId(userId);
    }

    public String getHash(){
        return linkId.getHash();
    }

    public void setHash(String hash){
        linkId.setHash(hash);
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getRedirects() {
        return redirects;
    }

    public void setRedirects(Integer redirects) {
        this.redirects = redirects;
    }

    public Float getEarnings() {
        return earnings;
    }

    public void setEarnings(Float earnings) {
        this.earnings = earnings;
    }

    public Float getEpc() {
        return epc;
    }

    public void setEpc(Float epc) {
        this.epc = epc;
    }

    public String getIgImageUrl() {
        return igImageUrl;
    }

    public void setIgImageUrl(String igImageUrl) {
        this.igImageUrl = igImageUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Integer getMerchantId() {
        return merchant.getMerchantId();
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}