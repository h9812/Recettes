package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Comment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImgRepo {
    @SerializedName("status")
    private String status;

    @SerializedName("filename")
    private String name;

    @SerializedName("path")
    private String mImg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setMessage(String name) {
        this.name = name;
    }

    public String getImage() {
        return mImg;
    }

}
