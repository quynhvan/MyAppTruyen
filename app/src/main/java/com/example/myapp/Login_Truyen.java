package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.TruyenRecycler.Activity.Main;

public class Login_Truyen extends AppCompatActivity {
    private EditText edtEmail, edtPass;
    private Button btnLogin, btnSignUp;
    private String email, pass;
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setWidget();
        setEventLogin();
        setEventSignUp();
    }
    public void setWidget(){
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);
        btnLogin = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }
    public void setEventLogin(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Truyen.this, Main.class);
                startActivity(intent);
            }
        });
    }
    public void setEventSignUp(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Truyen.this,Sign_Up_Truyen.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String email = data.getStringExtra(Constants.KEY_EMAIL_RESPONSE);
                String pass = data.getStringExtra(Constants.KEY_PASS_RESPONSE);

                edtPass.setText(email);
                edtPass.setText(pass);
            }
        }
    }
}
