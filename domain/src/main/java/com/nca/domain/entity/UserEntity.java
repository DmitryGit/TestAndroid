package com.nca.domain.entity;

public class UserEntity {

    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    private boolean isMan;
    private String imageUrl;

    public UserEntity(String firstName, String lastName, String fatherName, Integer age, boolean isMan, String imageURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.age = age;
        this.isMan = isMan;
        this.imageUrl = imageURL;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    //    private String username;
//    private int age;
//    private String profileUrl;

//    public UserEntity() {
//    }
//
//    public UserEntity(String username, int age, String profileUrl) {
//        this.username = username;
//        this.profileUrl = profileUrl;
//        this.age = age;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getProfileUrl() {
//        return profileUrl;
//    }
//
//    public int getAge() {
//        return age;
//    }
}
