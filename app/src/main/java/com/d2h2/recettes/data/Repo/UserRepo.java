package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Users;
import com.google.gson.annotations.SerializedName;

public class UserRepo {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Users mUsers;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Users getUsers() {
        return mUsers;
    }

    public void setUser(Users users) {
        this.mUsers = users;
    }
}
