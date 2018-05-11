package com.ucla.shopyourlikes.model;
//import com.ucla.shopyourlikes.model.audit.DateAudit;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name = "users")
public class User{
    @Id
    @NotBlank
    @Column(name = "userId")
    private Integer userId;

    @NotNull
    @Size(max = 50)
    @Column(name = "api_key")
    private String apiKey;

    @Size(max = 30)
    @Column(name = "instagram_id")
    private String instagramId;

    @Size(max = 30)
    @Column(name = "instagram_name")
    private String instagramName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "linkId.userId",
            fetch = FetchType.LAZY)
    private List<Link> links = new ArrayList<Link>();

    public User() {

    }

    public User(Integer userId, String apiKey){
        this.userId = userId;
        this.apiKey = apiKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public String getApiKey(){
        return apiKey;
    }

    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }

    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(String instagramId) {
        this.instagramId = instagramId;
    }

    public String getInstagramName() {
        return instagramName;
    }

    public void setInstagramName(String instagramName) {
        this.instagramName = instagramName;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
