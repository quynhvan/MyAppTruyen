package com.example.myapp.movieapp;

import com.example.myapp.objects.MovieDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServiceMovie {
    @GET("movie/popular?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<ApiResponse> getListMoviePopular();

    @GET("/movie/{movie_id}?api_key=1757841baf6268f9c88701a5a512c4d2")
    Call<MovieDetailResponse> getMovieDetail(@Path("movie_id") int movieId);

}
