package com.example.myapp.Retrofit.pratice;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallActivity extends AppCompatActivity{
    private RecyclerView re;
    private ArrayList<Owner> listOwner;
    private AdapterApi adapterApi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_call_api);
        initView();
    }

    private void initView() {
        re = findViewById(R.id.lv_call_api);
        adapterApi = new AdapterApi(CallActivity.this,listOwner);
        re.setAdapter(adapterApi);
        callApi();
    }

    private void callApi() {
        ConnectServer.getApiService().getAnswer().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()){
                    ApiResponse apiResponse = response.body();
                    for(Items items : apiResponse.getItems()){
                        listOwner.add(items.getOwner());
                    }
                }
                adapterApi.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}