package com.example.search;

public class Contact_model_Room {
    public String toLower;
    int img;
    String name,contact;
    public Contact_model_Room(int img, String name, String contact) {
        this.name=name;
        this.contact=contact;
        this.img=img;

    }
    public String getName() {
        return name;
    }



}
