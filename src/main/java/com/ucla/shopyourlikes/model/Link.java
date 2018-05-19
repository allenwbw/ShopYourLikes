package com.ucla.shopyourlikes.model;
import com.ucla.shopyourlikes.util.Utils;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "links")
public class Link {

    @EmbeddedId
    private LinkId linkId;

    @NotNull
    @Column(name = "creation_date")
    private Integer creationDate;

    @NotNull
    @Column(name = "last_updated")
    private Integer lastUpdated;

    @NotNull
    private Integer redirects;

    @NotNull
    private Float earnings;

    @NotNull
    private Integer ecpc;

    @Column(name = "ig_image_url")
    private String igImageUrl;

    @NotNull
    @Column(name = "original_url")
    private String originalUrl;

    @NotNull
    @Column(name = "merchant_id")
    private Integer merchantId;

    @NotNull
    @Column(name="merchant_name")
    private String merchantName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", insertable=false, updatable=false)
    private Merchant merchant;

    private String name;

    public Link() {
        this.linkId = new LinkId();
        this.merchantName = "N/A";
        this.merchantId = -1;
    }

    public String getUrl() {
        return "http://go.shopyourlikes.com/pi/" + linkId.getHash() + "?afId=" + linkId.getUserId();
    }

    public void setUrl(String url) {
        String hash = Utils.extractHash(url);
        linkId.setHash(hash);
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

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
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

    public Integer getEcpc() {
        return ecpc;
    }

    public void setEcpc(Integer ecpc) {
        this.ecpc = ecpc;
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
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}