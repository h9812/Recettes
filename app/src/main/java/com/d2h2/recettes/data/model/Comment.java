package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

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
    }
}
