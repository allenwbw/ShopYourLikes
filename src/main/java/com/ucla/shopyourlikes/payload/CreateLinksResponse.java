package com.ucla.shopyourlikes.payload;

import java.util.List;

public class CreateLinksResponse {
    private List<GenerateLinkResponse> generatedLinks;

    public CreateLinksResponse(){}
    public CreateLinksResponse(List<GenerateLinkResponse> generatedLinks){
        this.generatedLinks = generatedLinks;
    }

    public List<GenerateLinkResponse> getGeneratedLinks() {
        return generatedLinks;
    }

    public void setGeneratedLinks(List<GenerateLinkResponse> generatedLinks) {
        this.generatedLinks = generatedLinks;
    }
}
