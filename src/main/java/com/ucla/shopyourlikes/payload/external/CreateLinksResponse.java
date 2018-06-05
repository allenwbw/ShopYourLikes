package com.ucla.shopyourlikes.payload.external;


import com.ucla.shopyourlikes.payload.external.LinkResponse;

import java.util.List;

/**
 * This class contains all information about the CreateLinksResponse object,including all the getters and setters.
 */
public class CreateLinksResponse {
    private List<LinkResponse> generatedLinks;

    /**
     * default constructor
     */
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
