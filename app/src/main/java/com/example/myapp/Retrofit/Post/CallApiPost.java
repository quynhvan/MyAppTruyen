package com.example.myapp.Retrofit.Post;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallApiPost extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvResponse;
    private EditText edtTitle;
    private EditText edtBody;
    private Button btnSubmit;
    private String TAG = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initView();
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        edtTitle = findViewById(R.id.edt_title);
        edtBody = findViewById(R.id.edt_body);
        btnSubmit = findViewById(R.id.btn_submit);
        tvResponse = findViewById(R.id.tv_response);
    }
    private void initEvent(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString().trim();
                String body = edtBody.toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){
                    sendPost(title,body);
                }
            }
        });
    }

    private void sendPost(String title, String body) {
        ConnectServer.postApi().savePost(title, body,1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    showResponse(response.body().toString());
                    Log.i("van","post submitted to API"+ response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG,"unable to submit post to API");

            }
        });
    }

    private void showResponse(String response) {
        if(tvResponse.getVisibility() == View.GONE){
            tvResponse.setVisibility(View.VISIBLE);
        }
        tvResponse.setText(response);
    }
}
