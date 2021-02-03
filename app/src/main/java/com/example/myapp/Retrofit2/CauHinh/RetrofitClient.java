package com.example.myapp.Retrofit2.CauHinh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // retrofit muốn khởi tạo cần url (đường dẫn) để tương tác
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseurl){
        //OkHttp là phiên bản sau của http
        //hàm readTimeout: cho thời gian đọc dữ liệu trong bao lâu, mặc định là 3s
        // hàm writeTimeout: gửi dữ liệu lên cho n viết
        // kết nối tới server lâu quá thì set thời gian để ngắt việc kết nối
        // retryOnConnectionFailure: nếu connection gặp trục trặc thì n sẽ khôi phục lại kết nối, và thử lại xem có
        // kết nối được không?

        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                // một đường dẫn cơ sở để khởi tạo retrofit
                .baseUrl(baseurl)
                // kiểm soát những gì set ở Okhttp..
                // những cài đặt đó muốn set vào retrofit gọi qua thuộc tính client
                .client(builder)
                // khi có dữ liệu bên json muốn chuyển dữ liệu về gson
                // chức năng chuyển từ chữ của json về biến java thông qua tool
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
