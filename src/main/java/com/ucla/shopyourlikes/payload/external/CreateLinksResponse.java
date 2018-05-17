package com.ucla.shopyourlikes.payload.external;


import com.ucla.shopyourlikes.payload.external.LinkResponse;

import java.util.List;

public class CreateLinksResponse {
    private List<LinkResponse> generatedLinks;

    public CreateLinksResponse(){}

    public CreateLinksResponse(List<LinkResponse> generatedLinks){
        this.generatedLinks = generatedLinks;
    }

    public List<LinkResponse> getGeneratedLinks() {
        return generatedLinks;
    }

    public void setGeneratedLinks(List<LinkResponse> generatedLinks) {
        this.generatedLinks = generatedLinks;
    }
}
