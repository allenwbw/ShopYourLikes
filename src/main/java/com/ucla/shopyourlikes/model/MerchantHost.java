package com.ucla.shopyourlikes.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class contains all information about the MerchantHost object,including all the getters and setters.
 */
@Embeddable
public class MerchantHost {

    @NotBlank
    @NotNull
    @Column(name = "merchant_domain")
    private String merchantDomain;

    @NotBlank
    @NotNull
    @Column(name = "merchant_tld")
    private String merchantTld;

    public String getMerchantDomain() { return merchantDomain; }

    public void setMerchantDomain(String merchantDomain) { this.merchantDomain = merchantDomain; }

    public String getMerchantTld() { return merchantTld; }

    public void setMerchantTld(String merchantTld) { this.merchantTld = merchantTld; }
}
