package com.example.otp_verification;

public class User {
    public String name;
    public String age;
    public String lastName;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String age, String lastName) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }



}
