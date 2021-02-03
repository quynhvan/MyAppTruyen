package com.example.myapp.Retrofit.ApiResponse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @Expose
    @SerializedName("link")
    private String link;
    @Expose
    @SerializedName("display_name")
    private String displayName;
    @Expose
    @SerializedName("profile_image")
    private String profileImage;
    @Expose
    @SerializedName("user_type")
    private String userType;
    @Expose
    @SerializedName("user_id")
    private int userId;
    @Expose
    @SerializedName("reputation")
    private int reputation;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
