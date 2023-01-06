package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String _etEmail = etEmail.getText().toString().trim();
        String _etPassword = etPassword.getText().toString().trim();
        Button btnsignIn = findViewById(R.id.btnsignIn);
        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignIn_Activity.this,homescreenActivity.class);
                startActivity(intent);

            }
        });

        TextView create_account =findViewById(R.id.tvcreateAccount);
        create_account.setOnClickListener(new View.OnClickListener(){
         @Override
        public void onClick(View view) {
            Intent intent=new Intent(SignIn_Activity.this,SignUp_Activity.class);
            startActivity(intent);
        }
    });

    }
}




