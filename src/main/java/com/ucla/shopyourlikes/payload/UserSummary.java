package com.ucla.shopyourlikes.payload;

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