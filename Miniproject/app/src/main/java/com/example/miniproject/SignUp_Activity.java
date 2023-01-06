package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText etName =findViewById(R.id.etName);
        EditText etPhone =findViewById(R.id.etPhone);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String _etName =etName.getText().toString().trim();
        String _etPhone=etPhone.getText().toString().trim();
        String _etEmail = etEmail.getText().toString().trim();
        String _etPassword = etPassword.getText().toString().trim();
        Button register = findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp_Activity.this,homescreenActivity.class);
                startActivity(intent);

            }
        });

        TextView account =findViewById(R.id.tvalreadylogin);
        account.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp_Activity.this,SignIn_Activity.class);
                startActivity(intent);
            }
        });

    }
    }
