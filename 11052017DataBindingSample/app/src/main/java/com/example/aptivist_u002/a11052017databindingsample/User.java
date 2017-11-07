package com.example.aptivist_u002.a11052017databindingsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Aptivist-U002 on 11/5/2017.
 */

public class User extends BaseObservable {
    private String firstName;
    private String lastName;
    private String profilePicture;

    private ObservableField<String> tmp = new ObservableField<>("");

    public User(String firstName, String lastName, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }


    public String getTmp() {
        return tmp.get();
    }

    public void setTmp(String tmp) {
        this.tmp.set(tmp);
    }

    public void onButtonClicked() {
        System.out.println("onButtonClicked");
    }


    public void changeData() {
        setFirstName("JACP");
    }

    public void retrieveDataFromView() {
        System.out.println("TAG_" + tmp.get());
    }
}
