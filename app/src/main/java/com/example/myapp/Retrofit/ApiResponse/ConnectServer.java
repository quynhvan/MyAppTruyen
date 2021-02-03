package com.example.myapp.Retrofit.ApiResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//   baseUrl:  https://api.stackexchange.com/2.2/
public class ConnectServer {
    private static Retrofit retrofit = null;
    private static final String Base_Url ="https://api.stackexchange.com/2.2/";
    // lưu ý khi đặt dâu chéo

//    public static Retrofit getClient(){
    public static APIService getAPIService(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIService.class);
    }
}
