package com.d2h2.recettes.model;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class User {
    private String name, email, url_avatar;

    public User(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("User", MODE_PRIVATE);
        this.name = sharedPreferences.getString("name","Recettes");
        this.email = sharedPreferences.getString("email" , "Recettes@recettes.com");
        this.url_avatar = sharedPreferences.getString("url","null");
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

}

