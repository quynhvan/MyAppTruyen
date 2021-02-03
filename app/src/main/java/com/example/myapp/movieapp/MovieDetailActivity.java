package com.example.myapp.movieapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.Constants;
import com.example.myapp.R;
import com.example.myapp.objects.MovieDetailResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {
    private int movieId;
    private ImageView ivMovie;
    private TextView tvTitleMovie,tvGenre,tvRunTime,tvNetwork;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        movieId = getIntent().getIntExtra(Constants.KEY_MOVIE_DETAIL,0);
        initView();
        callApi();
    }
    public void initView(){
         ivMovie = findViewById(R.id.iv_movie_detail);
         tvTitleMovie= findViewById(R.id.tv_title_movie);
         tvGenre = findViewById(R.id.tv_genre);
         tvRunTime = findViewById(R.id.tv_run_time);
         tvNetwork = findViewById(R.id.tv_network);
    }
    private void callApi() {
        ConnectServerMovie.getAPIService().getMovieDetail(movieId).enqueue(new Callback<MovieDetailResponse>() {
            // enqueue gọi api
            @Override
            public void onResponse(Call<MovieDetailResponse> call, Response<MovieDetailResponse> response) {
                Log.e("kevin", "onFailure: "+ call.request().toString());
                if (response.isSuccessful()) {
                    MovieDetailResponse response1 = response.body();

                }
            }
            @Override

            public void onFailure(Call<MovieDetailResponse> call, Throwable t) {
                Log.e("kevin", "onFailure: "+ call.request().toString());
            }
        });
    }
}

