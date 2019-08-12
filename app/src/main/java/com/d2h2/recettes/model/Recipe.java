package com.d2h2.recettes.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    private int mId;
    private String mName;
    private String mDescription;
    private int[] mIngredientIds;
    private List<String> mIngredientAmounts;
    private List<String> mDirections;
    private int[] mTagIds;
    private int mOwnerId;
    private int mNumberOfLikes;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int[] getmIngredientIds() {
        return mIngredientIds;
    }

    public void setmIngredientIds(int[] mIngredientIds) {
        this.mIngredientIds = mIngredientIds;
    }

    public List<String> getmIngredientAmounts() {
        return mIngredientAmounts;
    }

    public void setmIngredientAmounts(List<String> mIngredientAmounts) {
        this.mIngredientAmounts = mIngredientAmounts;
    }

    public List<String> getmDirections() {
        return mDirections;
    }

    public void setmDirections(List<String> mDirections) {
        this.mDirections = mDirections;
    }

    public int[] getmTagIds() {
        return mTagIds;
    }

    public void setmTagIds(int[] mTagIds) {
        this.mTagIds = mTagIds;
    }

    public int getmOwnerId() {
        return mOwnerId;
    }

    public void setmOwnerId(int mOwnerId) {
        this.mOwnerId = mOwnerId;
    }

    public int getmNumberOfLikes() {
        return mNumberOfLikes;
    }

    public void setmNumberOfLikes(int mNumberOfLikes) {
        this.mNumberOfLikes = mNumberOfLikes;
    }

    @Override
    public String toString() {
        return mName;
    }
}
