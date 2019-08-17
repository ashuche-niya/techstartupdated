package com.example.tech_start;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

//    @Headers("Content-Type: application/json")

    @POST("signin")
    Call<MainUser> signInUser(@Body MainUser mainUser);

}
