package com.hyetec.appdemo.api;

import com.hyetec.appdemo.vo.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("/getUser/{userId}")
    Call<User> getUser(@Path("userId") String userId);
}
