package com.ucla.shopyourlikes.database;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private Integer user_id;

    @Column(unique=true)
    private String username;

    private String api_key;
    private String instagram_id;
    private String instagram_name;

    public Integer getUserId() {return user_id;}
    public String getUsername() {return username;}
    public String getApiKey() {return api_key;}
    public String getInstagramId() {return instagram_id;}
    public String getInstagram_name(){return instagram_name;}

}
