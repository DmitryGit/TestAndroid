package com.nca.domain.entity;

public class UserEntity {

    private String username;
    private int age;
    private String profileUrl;

    public UserEntity() {
    }

    public UserEntity(String username, int age, String profileUrl) {
        this.username = username;
        this.profileUrl = profileUrl;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public int getAge() {
        return age;
    }
}
