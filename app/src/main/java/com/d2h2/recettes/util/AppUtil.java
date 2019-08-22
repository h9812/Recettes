package com.d2h2.recettes.util;

import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.RetrofitClient;

public class AppUtil {
    public static final String BASE_URL = "http://103.92.30.250:8080/api/";

    public static Repository getRepository() {
        return RetrofitClient.getClient(BASE_URL).create(Repository.class);
    }
}
