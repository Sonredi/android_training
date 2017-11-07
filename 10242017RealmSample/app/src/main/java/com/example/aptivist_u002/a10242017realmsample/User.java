package com.example.aptivist_u002.a10242017realmsample;

import io.realm.RealmObject;

/**
 * Created by Aptivist-U002 on 10/24/2017.
 */

public class User extends RealmObject {

    private int id;
    private String name;
    private int age;

    public User() {

    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
