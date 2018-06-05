package com.ucla.shopyourlikes.payload.external;

import javax.validation.constraints.NotBlank;

/**
 * This class contains all information about the LoginRequest object,including all the getters and setters.
 */
public class LoginRequest {
    @NotBlank
    private String userId;

    @NotBlank
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
