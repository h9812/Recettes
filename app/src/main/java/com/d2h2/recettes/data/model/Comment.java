package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;


public class Comment {
    @Getter
    @Setter
    @SerializedName("content")
    private String content;

    @Getter
    @Setter
    @SerializedName("_id")
    private String id;

    @Getter
    @Setter
    @SerializedName("ownerId")
    private String owner;

    @Getter
    @Setter
    @SerializedName("modifiedDate")
    private String date;
}