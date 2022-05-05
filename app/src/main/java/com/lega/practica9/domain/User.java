package com.lega.practica9.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String User;
    private String surName;
    private String edad;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.User);
        dest.writeString(this.surName);
        dest.writeString(this.edad);
    }

    public void readFromParcel(Parcel source) {
        this.User = source.readString();
        this.surName = source.readString();
        this.edad = source.readString();
    }

    public User() {
    }

    protected User(Parcel in) {
        this.User = in.readString();
        this.surName = in.readString();
        this.edad = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
