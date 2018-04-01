package com.nca.domain.entity;

public class UserEntityHW11 {

    private String id;
    private String username;
    private Integer age;
    private String profileUrl;

    public UserEntityHW11() {
    }

    public UserEntityHW11(String username, Integer age, String profileUrl, String id) {
        this.username = username;
        this.profileUrl = profileUrl;
        this.age = age;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
