package com.art_shop.art_shop.models;

public class User_infa {
    private String first_name;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public User_infa(String name){
        this.first_name = name;
    }
    public User_infa(){};
}
