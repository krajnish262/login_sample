package com.example.hksrajnishtask.Network;

import com.example.hksrajnishtask.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface Api {

    @POST("login.php")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

}