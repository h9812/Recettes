package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

<<<<<<< HEAD
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
=======
import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    @SerializedName("recipeId")
    private String mRecipeId;
    @SerializedName("id")
    private String mCommentId;
    @SerializedName("ownerId")
    private String mAuthorId;
    @SerializedName("content")
    private String mContent;
    @SerializedName("modifiedDate")
    private Date mModifiedDate;

    public String getRecipeId() {
        return mRecipeId;
    }

    public void setRecipeId(String mRecipeId) {
        this.mRecipeId = mRecipeId;
    }

    public String getCommentId() {
        return mCommentId;
    }

    public void setCommentId(String mCommentId) {
        this.mCommentId = mCommentId;
    }

    public String getAuthorId() {
        return mAuthorId;
    }

    public void setAuthorId(String mAuthorId) {
        this.mAuthorId = mAuthorId;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public Date getModifiedDate() {
        return mModifiedDate;
    }

    public void setModifiedDate(Date mModifiedDate) {
        this.mModifiedDate = mModifiedDate;
>>>>>>> Do1
    }
}
