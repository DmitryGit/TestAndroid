package com.nca.data.entity;


import com.google.gson.annotations.SerializedName;

public class User {

//    @SerializedName("object_id")
    @SerializedName("objectId")
    private String objectId;

    @SerializedName("username")
    private String username;

    @SerializedName("profileUrl")
    private String profileUrl;

    @SerializedName("age")
    private int age;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
