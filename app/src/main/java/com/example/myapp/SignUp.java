package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText edtEmail, edtPass, edtName;
    private Button btnSignUp;
    private String name, email, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setWidget();
        setEvent();
    }
    public void setWidget(){
        edtEmail = findViewById(R.id.edt_email);
        edtName = findViewById(R.id.edt_name);
        edtPass = findViewById(R.id.edt_pass);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }
    public void setEvent(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edtEmail.getText().toString();
                name= edtName.getText().toString();
                pass = edtPass.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(Constants.KEY_EMAIL_RESPONSE,email);
                intent.putExtra(Constants.KEY_PASS_RESPONSE,pass);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}