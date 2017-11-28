package com.jacp.a11132017mvpbindmaterialdesignassignment;

/**
 * Created by Aptivist-U002 on 11/13/2017.
 */

public class User {

    private String firstName;
    private String lastName;
    private String age;

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
