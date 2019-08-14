package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("content")
    private String content;
    @SerializedName("_id")
    private String id;
    @SerializedName("ownerId")
    private String owner;
    @SerializedName("modifiedDate")
    private String date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
