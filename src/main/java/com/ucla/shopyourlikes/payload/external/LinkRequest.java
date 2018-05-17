package com.ucla.shopyourlikes.payload.external;

import javax.validation.constraints.NotBlank;

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


