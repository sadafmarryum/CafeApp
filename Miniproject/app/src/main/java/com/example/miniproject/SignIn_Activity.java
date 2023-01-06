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
import com.google.firebase.auth.FirebaseUser;

public class SignIn_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btnsignIn = findViewById(R.id.btnsignIn);
        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate_and_register_user();
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

    private void validate_and_register_user()
    {
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String _etEmail = etEmail.getText().toString().trim();
        String _etPassword = etPassword.getText().toString().trim();

        if(_etEmail.isEmpty())
            {
            etEmail.setError("Please Enter Valid Email Address");
            etEmail.requestFocus();
            return;
            }
        if(_etPassword.isEmpty())
            {
            etPassword.setError("Please Enter Valid Password");
            etPassword.requestFocus();
            return;
            }
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(_etEmail,_etPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    Toast.makeText(SignIn_Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SignIn_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();


            }
        });
        }
}




