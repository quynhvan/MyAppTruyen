//package com.example.myapp.Retrofit.ApiResponse.activity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapp.R;
//import com.example.myapp.Retrofit.ApiResponse.ConnectServer;
//import com.example.myapp.Retrofit.ApiResponse.adapter.AdapterListViewApi;
//import com.example.myapp.Retrofit.ApiResponse.model.ApiResponse;
//import com.example.myapp.Retrofit.ApiResponse.model.Items;
//import com.example.myapp.Retrofit.ApiResponse.model.Owner;
//import com.example.myapp.movieapp.AdapterMovie;
//import com.example.myapp.movieapp.Movie;
//
//import java.util.ArrayList;
//
////import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class CallApiActivity extends AppCompatActivity {
//    private RecyclerView recy;
//    private AdapterMovie adapterMovie;
//    private ArrayList<Movie> listMovie = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recyclerview_movie_main);
//
//        recyclerView = findViewById(R.id.re_movie);
//        adapterMovie = new AdapterMovie(CallApiActivity.this, listMovie);
//        recyclerView.setAdapter(adapterMovie);
//        callApi();
//    }
//
//    private void callApi() {
//        ConnectServer.getAPIService().getAnswers().enqueue(new Callback<ApiResponse>() {
//            // enqueue gọi api
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                // khi có dữ liệu trả về
////                // response là object api... là cái mình mong muốn
//                if (response.isSuccessful()) {
//                    ApiResponse response1 = response.body();
//                    for (Items item : response1.getItems()) {
//                        listMovie.add(item.getOwner());
//                    }
//                    adapterMovie.notifyDataSetChanged();
//                    //Log.e("kevin","displayName"+ owner.getDisplayName());
//                }
//            }
//
//            @Override
//            // khi khong có dữ liệu trả về thì báo lõi
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//
//            }
//        });
//    }
//}
////    private void callApi(){
////        ConnectServer.getAPIService().getAnswers().enqueue(new Callback<ApiResponse>() {
////
////            @Override
////            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
////
////                if(response.isSuccessful()){
////                    // body trả về dúng APIResponse
////                    //response gồm listItem ,
////                    ApiResponse mResponse = response.body();
//////                    Owner owner = mResponse.getItems().get(0).getOwner();
////                    for(Items item:mResponse.getItems()){
////                        listOwers.add(item.getOwner());
////                    }
////                    adapterListViewApi.notifyDataSetChanged();
//////
////                }
////            }
////
////            @Override
////            public void onFailure(Call<ApiResponse> call, Throwable t) {
////
////            }
////        });
////    }
//
