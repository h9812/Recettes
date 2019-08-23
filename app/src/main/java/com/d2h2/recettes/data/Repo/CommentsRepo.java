package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Comment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CommentsRepo {
    @Getter
    @Setter
    @SerializedName("status")
    private String status;

    @Getter
    @Setter
    @SerializedName("message")
    private String message;

    @Getter
    @Setter
    @SerializedName("data")
    private List<Comment> comments;
}
