package com.example.myapp.Retrofit2.CauHinh;

public class APIUtils {
    //khi truy cập đên server chỉ có một đường dẫn
    // nên để final thì người khác sẽ không thay đổi được
    // có đường dẫn rồi làm sao để kết nối tới thằng gửi dữ liệu lên
    // ( hay làm sao để gửi phương thức lên cho server)
    public static final String Base_Url = "http://192.168.43.16/QuanLySinhVien/";
    // sau khi đã kết nối, cấu hình retrofit xong, có đường dẫn làm sao để gửi phương thúc lên cho server
    // tạo function : gọi lại những phương thức của DataClient để gửi lên cho serer
    // getData: dùng để nhận và gửi dữ liệu
    // khi DataClient viết một phương thức thì sẽ nhờ getData() làm trung gian gửi phương thức lên
    // và khi phương thức đó có dữ liệu trả về thì sẽ trả về cho DataClient
    //getData viết function để gửi và nhận dữ liệu về để chứa trong interface DataClient
    public static DataClient getData(){
        // sau khi có dữ liệu phương thức này sẽ chứa dữ liệu vào trong DataClient
        // truyền vào Base_Ur cho getclient
        // create : khởi tạo nơi chứa dữ liệu
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
