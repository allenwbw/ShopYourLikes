package com.ucla.shopyourlikes.payload.external;

/**
 * This class contains all information about the UserSummary object,including all the getters and setters.
 */
public class UserSummary {
    private String userId;

    public UserSummary(String userId){
        this.userId = userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}