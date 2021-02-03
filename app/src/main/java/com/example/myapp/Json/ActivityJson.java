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

public class ActivityJson extends Activity {
    private String Van = null;
    private ArrayList<ColorObject> listColor = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        String content = LoadFileFromAssests("json_f");
        Log.e(Van,"json"+content);
        TextView json = findViewById(R.id.tv_color);
        json.setText(content);

        // bóc tách dữ liệu
        // try catch : thực hiện trong try_catch để đảm bảo chương trình không bị gián đoạn trong khối
        // try bị lỗi, câu lệnh tiếp theo vẫn thực hiện
        try {
            //lay ra mảng object
            JSONArray jsonArray = new JSONArray(content);
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // có object ở vị trí i trong mảng rồi
                // lay ra
                String color = jsonObject.getString("color");
                String value = jsonObject.getString("value");

                ColorObject colorObject = new ColorObject(color,value);
                // thêm object color vào mảng color
                listColor.add(colorObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        Log.e("Van","size"+ listColor.size());
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
