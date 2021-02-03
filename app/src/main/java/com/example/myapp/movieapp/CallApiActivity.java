package com.example.myapp.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Constants;
import com.example.myapp.R;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallApiActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterMovie adapterMovie;
    private ArrayList<Movie> listMovie = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_movie_main);

        recyclerView = findViewById(R.id.re_movie);
        recyclerView.setLayoutManager(new GridLayoutManager(CallApiActivity.this, 3));
        adapterMovie = new AdapterMovie(CallApiActivity.this, listMovie, new AdapterMovie.OnClickItemMovie() {
            @Override
            public void onClickItemMovie(int position) {
                Movie movie = listMovie.get(position);
                Intent intent = new Intent();
                intent.putExtra(Constants.KEY_MOVIE_DETAIL,movie.getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapterMovie);
        callApi();
    }

    private void callApi() {
        ConnectServerMovie.getAPIService().getListMoviePopular().enqueue(new Callback<ApiResponse>() {
            // enqueue gọi api
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.e("kevin", "onFailure: "+ call.request().toString());
                // khi có dữ liệu trả về
//                // response là object api... là cái mình mong muốn
                if (response.isSuccessful()) {
                    ApiResponse response1 = response.body();
                    listMovie.addAll(response1.getResults());
                    adapterMovie.notifyDataSetChanged();
                    //Log.e("kevin","displayName"+ owner.getDisplayName());
                }
            }

            @Override
            // khi khong có dữ liệu trả về thì báo lõi
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("kevin", "onFailure: "+ call.request().toString());
            }
        });
    }
}
//    private void callApi(){
//        ConnectServer.getAPIService().getAnswers().enqueue(new Callback<ApiResponse>() {
//
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//
//                if(response.isSuccessful()){
//                    // body trả về dúng APIResponse
//                    //response gồm listItem ,
//                    ApiResponse mResponse = response.body();
////                    Owner owner = mResponse.getItems().get(0).getOwner();
//                    for(Items item:mResponse.getItems()){
//                        listOwers.add(item.getOwner());
//                    }
//                    adapterListViewApi.notifyDataSetChanged();
////
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//
//            }
//        });
//    }

