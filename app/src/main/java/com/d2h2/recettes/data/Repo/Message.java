package com.d2h2.recettes.data.Repo;
import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}