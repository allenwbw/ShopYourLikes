package com.ucla.shopyourlikes.payload.external;

/**
 * This class contains all information about the ApiResponse object,including all the getters and setters.
 */
public class ApiResponse {
    private Boolean success;
    private String message;

    public ApiResponse(Boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess(){
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
