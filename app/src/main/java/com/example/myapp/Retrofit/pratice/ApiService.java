package com.example.myapp.Retrofit.pratice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<ApiResponse> getAnswer();
}
