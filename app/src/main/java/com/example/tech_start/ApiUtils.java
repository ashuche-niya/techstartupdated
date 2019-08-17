package com.example.tech_start;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://agile-headland-13060.herokuapp.com/";

    public static ApiInterface getAPIService() {

        return ApiManager.getClient(BASE_URL).create(ApiInterface.class);
    }
}
