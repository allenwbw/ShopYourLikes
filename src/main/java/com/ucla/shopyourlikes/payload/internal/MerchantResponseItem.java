package com.ucla.shopyourlikes.payload.internal;

/**
 * This class contains all information about the MerchantResponseItem object,including all the getters and setters.
 */
public class MerchantResponseItem {

    private Integer merchantId;
    private String merchantName;
    private String merchantUrl;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

}
