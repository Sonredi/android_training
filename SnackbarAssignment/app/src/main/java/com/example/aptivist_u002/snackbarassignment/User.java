package com.example.aptivist_u002.snackbarassignment;

/**
 * Created by Aptivist-U002 on 10/20/2017.
 */

public class User {

    private String FirstName;
    private String LastName;
    private String image;

    public User(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
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
