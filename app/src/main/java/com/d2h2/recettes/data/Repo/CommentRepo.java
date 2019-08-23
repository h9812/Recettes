package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Comment;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class CommentRepo {
    @Getter
    @Setter
    @SerializedName("message")
    private String message;

    @Getter
    @Setter
    @SerializedName("data")
    private Comment comment;
}
