package com.ucla.shopyourlikes.payload;

import javax.validation.constraints.NotNull;

public class GenerateLinkRequest {
    @NotNull
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
