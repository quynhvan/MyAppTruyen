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

public class JsonActivity extends Activity {
    private ArrayList<Error> listError = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        String error = LoadFileFromAssests("json-error");
        TextView tverror = findViewById(R.id.tv_color);
        tverror.setText(error);

        try {
            JSONObject jsonerror = new JSONObject(error);
            JSONArray jsonArray = jsonerror.getJSONArray("error");
            for(int i=0; i< jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String status = jsonObject.getString("status");
                String detail = jsonObject.getString("detail");
                JSONObject soure = jsonObject.getJSONObject("source");
                String pointer = jsonObject.getString("pointer");
                String title ="";

                if(jsonObject.has("title")){
                    title = jsonObject.getString("title");
                }

                Error error1 = new Error(status,detail,pointer,title);
                listError.add(error1);
                Log.e("error","error"+listError.get(1).getPointer());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public String LoadFileFromAssests(String filename){
        String contents = "";
        try {
            InputStream stream = getAssets().open(filename);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            contents = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
