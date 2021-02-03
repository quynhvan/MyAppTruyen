package com.example.myapp.movieapp;





import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//   baseUrl:  https://api.stackexchange.com/2.2/
public class ConnectServerMovie {
    private static Retrofit retrofit = null;
    private static final String Base_Url ="https://api.themoviedb.org/3/";
    // lưu ý khi đặt dâu chéo

    //    public static Retrofit getClient(){
    public static ApiServiceMovie getAPIService(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiServiceMovie.class);
    }
}
