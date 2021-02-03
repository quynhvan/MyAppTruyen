package com.example.myapp.Retrofit.ApiResponse;

import com.example.myapp.Retrofit.ApiResponse.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<ApiResponse> getAnswers();

}
