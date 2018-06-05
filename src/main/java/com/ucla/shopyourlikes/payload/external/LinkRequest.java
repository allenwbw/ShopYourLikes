package com.ucla.shopyourlikes.payload.external;

import javax.validation.constraints.NotBlank;

/**
 * This class contains all information about the LinkRequest object,including all the getters and setters.
 */
public class LinkRequest {
    @NotBlank
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}


