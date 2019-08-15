package com.d2h2.recettes.data.model;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class User {
    private String name, email, url_avatar,id;

    public User(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User", MODE_PRIVATE);
        this.name = sharedPreferences.getString("name",null);
        this.email = sharedPreferences.getString("email" , "null");
        this.url_avatar = sharedPreferences.getString("url","null");
        this.id = sharedPreferences.getString("id","null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_avatar() {
        return url_avatar;
    }

    public void setUrl_avatar(String url_avatar) {
        this.url_avatar = url_avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

