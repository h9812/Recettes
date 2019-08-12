package com.d2h2.recettes.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private int mId;
    private String mName;

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

    @Override
    public String toString() {
        return mName;
    }
}
