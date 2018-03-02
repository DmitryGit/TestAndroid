package com.nca.testandroid.classwork6;

public class User {

    private String imageURL;
    private String name;
    private String surname;

    public User(String imageURL, String name, String surname) {
        this.imageURL = imageURL;
        this.name = name;
        this.surname = surname;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
