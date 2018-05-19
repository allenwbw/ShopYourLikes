package com.ucla.shopyourlikes.payload.external;

import java.util.List;

public class LinkUpdate {

    private Integer timestamp;
    private List<LinkResponse> links;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public List<LinkResponse> getLinks() {
        return links;
    }

    public void setLinks(List<LinkResponse> links) {
        this.links = links;
    }
}
