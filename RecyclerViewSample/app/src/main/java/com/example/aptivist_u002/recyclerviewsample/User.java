package com.example.aptivist_u002.recyclerviewsample;

/**
 * Created by Aptivist-U002 on 10/19/2017.
 */

public class User {

    private String FirstName;
    private String LastName;
    private String image;

    public User(String firstName, String lastName, String image) {
        FirstName = firstName;
        LastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
