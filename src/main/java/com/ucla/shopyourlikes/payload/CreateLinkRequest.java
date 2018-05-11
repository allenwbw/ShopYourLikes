package com.ucla.shopyourlikes.payload;

import javax.validation.constraints.NotBlank;

public class CreateLinkRequest {

    @NotBlank
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
