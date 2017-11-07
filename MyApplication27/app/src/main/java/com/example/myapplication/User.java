package com.example.myapplication;

/**
 * Created by Aptivist-U002 on 10/19/2017.
 */

public class User {
    private String Firstname;
    private String lastName;
    private String image;

    public User(String firstname, String lastName, String image) {
        Firstname = firstname;
        this.lastName = lastName;
        this.image = image;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
