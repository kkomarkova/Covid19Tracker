package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //Set display launch app for 3 second
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Go to the MainActivity after 3 seconds
                {
                    Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                }
            }
        }, 3000);


    }

}