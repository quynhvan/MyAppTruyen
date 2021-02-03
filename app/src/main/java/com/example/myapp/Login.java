package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText edtEmail, edtPass;
    private Button btnSignUp, btnSignIn;
    private String email,pass;
    private static final int REQUEST_CODE1= 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setWidget();
//        setEventSignIn();
        setEventSignUp();
    }

    public void setWidget(){
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);
        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }

//    public void setEventSignIn(){
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
    public void setEventSignUp(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivityForResult(intent,REQUEST_CODE1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE1){
            if(resultCode == RESULT_OK){
                email = data.getStringExtra(Constants.KEY_EMAIL_RESPONSE);
                pass = data.getStringExtra(Constants.KEY_PASS_RESPONSE);

                edtEmail.setText(email);
                edtPass.setText(pass);
            }
        }
    }
}