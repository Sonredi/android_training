package com.example.aptivist_u002.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aptivist-U002 on 10/6/2017.
 */

public class Student implements Parcelable {

    private String name;
    private String lastName;
    private int grade;

    public Student(String name, String lastName, int grade) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    protected Student(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        grade = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeInt(grade);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
