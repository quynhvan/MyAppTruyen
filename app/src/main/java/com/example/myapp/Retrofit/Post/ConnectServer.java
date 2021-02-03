package com.example.myapp.Retrofit.Post;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectServer {
    private static Retrofit retrofit = null;
    private static final String BASE_URL ="http://jsonplaceholder.typicode.com/";
    public static ApiServicePost postApi(){
        if(retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiServicePost.class);
    }
}
