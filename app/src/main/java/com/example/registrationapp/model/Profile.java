package com.example.registrationapp.model;

public class Profile implements java.io.Serializable {
    private String username;
    private String gender;

    public Profile(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
