package com.example.myapp.Json;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class JsonError extends Activity {
    private String Van = "";
    private ArrayList<Error> listeError = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        String error = LoadFileFromAssests("json_error");
        Log.e(Van, "json" + error);
        TextView json = findViewById(R.id.tv_color);
        json.setText(error);

        // bóc tách dữ liệu
        // try catch : thực hiện trong try_catch để đảm bảo chương trình không bị gián đoạn trong khối
        // try bị lỗi, câu lệnh tiếp theo vẫn thực hiện
        // bóc tách
        try {

            JSONObject jsonError = new JSONObject(error);
            JSONArray arrErrors = jsonError.getJSONArray("error");
            for (int i = 0; i < arrErrors.length(); i++) {
                JSONObject objerror = arrErrors.getJSONObject(i);
                String status = objerror.getString("Status");
                JSONObject source = objerror.getJSONObject("source");
                String pointer = objerror.getString("pointer");
                String detail = objerror.getString("detail");
                String title = "";
//                Source sourceObj = new Source(pointer);


                if (objerror.has("title")) {
                    title = objerror.getString("title");
                }
//                Error error1 = new Error(status,SouceObj,detail,title);
                Error error1 = new Error(status, pointer, detail, title);
                listeError.add(error1);

                Log.e("error", "error" + listeError.get(1).getPointer());

            }
            //duyệt for each
            for (Error error1 : listeError) {
                Log.e(Van, "status" + error1.getStatus());
                Log.e(Van, "pointer" + error1.getPointer());
                Log.e(Van, "detail" + error1.getDetail());
                Log.e(Van, "title" + error1.getTitle());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String LoadFileFromAssests(String fileName) {
        //
        String tContents = "";

        try {
            //getassets truy cập đến mục assests
            // để đọc được file cần input stream
            // open mở file
            // inputStream để đọc file
            InputStream stream = getAssets().open(fileName);

            // kiểm tra xem file có giá trị hay không?
            // lấy ra size của file
            int size = stream.available();
            // tạo một mảng để lưu dữ liệu đọc được
            // buffer chỉ là tên
            // buffer là nơi lưu trữ
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            // để chuyển từ một mang byte sang string
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;
    }
}
