package com.example.myapp.Retrofit2.CauHinh;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Part;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface DataClient {
    // khi gửi gì đó dưới dạng file hình ảnh, âm thanh không phải dạng kiểu chuỗi thì
    // gọi đến từ khóa multipart
    @Multipart
    // khi gửi lên thì sử dụng post
    // gửi lên file uploadhinhanh có thể thực hiện việc upload ảnh
    @POST("uploadhinhanh.php")
    // sau khi gửi dữ liệu lên thì tạo một function
    // muốn gửi gì lên thì truyền trong function này
    // function dưới dạng CALL<T>
    // khi server nhận được dữ liệu , xử lý xong, trả về dạng dữ liêu bất kì
    // nếu là dạng chuỗi thì Call<String>
    // nếu trả về mản Call<Array>
    // @part : khi chọn đến file uploadhinhanh thì sẽ gửi hình ảnh lên cho server luôn
    // thông qua từ khóa @part ( gửi cái gì đó lên cho server: ảnh, âm thanh,...)
    //MultipartBody.Part: xác nhận lại kiểu dữ liệu gửi đi,
    Call<String> UploadPhoto (@Part MultipartBody.Part photo);
}
