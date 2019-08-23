package com.d2h2.recettes.data.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Ingredient implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
