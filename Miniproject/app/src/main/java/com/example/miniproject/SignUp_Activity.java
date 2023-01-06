package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button register = findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_new_user();

            }
        });
        TextView account = findViewById(R.id.tvalreadylogin);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void create_new_user() {
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String _etName = etName.getText().toString().trim();
        String _etPhone = etPhone.getText().toString().trim();
        String _etEmail = etEmail.getText().toString().trim();
        String _etPassword = etPassword.getText().toString().trim();


        if (_etName.isEmpty()) {
            etName.setError("Please Enter Valid Name");
            etName.requestFocus();
            return;
        }
        if (_etPhone.isEmpty()) {
            etPhone.setError("Please Enter Valid Age");
            etPhone.requestFocus();
            return;
        }

        if (_etEmail.isEmpty()) {
            etEmail.setError("Please Enter Valid Email");
            etEmail.requestFocus();
            return;
        }
        if (_etPassword.isEmpty()) {
            etPassword.setError("Please Enter Valid Password");
            etPassword.requestFocus();
            return;
        }

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(_etEmail, _etPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUp_Activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp_Activity.this,SignIn_Activity.class));
                    finish();
                }
                else
                    Toast.makeText(SignUp_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}

