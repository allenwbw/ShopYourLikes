package com.ucla.shopyourlikes.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This class contains all information about the linkId object,including all the getters and setters.
 */

@Embeddable
public class LinkId implements Serializable{
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Column(columnDefinition = "CHAR(40)")
    private String hash;

    /**
     * default constructor with no params
     */
    public LinkId() {

    }

    /**
     * constructor with params
     * @param userId
     * @param hash
     */
    public LinkId(Integer userId, String hash){
        this.userId = userId;
        this.hash = hash;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkId that = (LinkId) o;
        if (!userId.equals(that.userId)) return false;
        return hash.equals(that.hash);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + hash.hashCode();
        return result;
    }
}
