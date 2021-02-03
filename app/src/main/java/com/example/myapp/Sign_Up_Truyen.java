package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_Up_Truyen extends AppCompatActivity {
    private EditText edtName, edtEmail, edtPass;
    private Button btnSignUp;
    private String name,email,pass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setWidget();
        setEvent();
    }
    public void setWidget(){
        edtName= findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }
    public void setEvent(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                email = edtEmail.getText().toString();
                pass = edtPass.getText().toString();

                intent.putExtra(Constants.KEY_EMAIL_RESPONSE,email);
                intent.putExtra(Constants.KEY_PASS_RESPONSE,pass);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
