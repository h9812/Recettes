package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Comment;
import com.google.gson.annotations.SerializedName;

public class CommentRepo {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Comment comment;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
