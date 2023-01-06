package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
     //   ImageView image=findViewById(R.id.image);

            // create a handler to schedule a task to be executed after a delay
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // close the splash screen and open the main activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }, 5000); // delay for 5 seconds
        }



    }
