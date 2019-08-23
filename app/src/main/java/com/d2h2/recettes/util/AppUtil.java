package com.d2h2.recettes.util;

import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.RetrofitClient;

public class AppUtil {
    public static final String BASE_URL = "http://12.22.88.102:8081/";

    public static Repository getRepository() {
        return RetrofitClient.getClient(BASE_URL).create(Repository.class);
    }
}
