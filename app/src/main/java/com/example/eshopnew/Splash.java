package com.example.eshopnew;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private static int SPLACH_TIME_OUT=4100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent= new Intent(Splash.this,LoginActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLACH_TIME_OUT);
    }
}