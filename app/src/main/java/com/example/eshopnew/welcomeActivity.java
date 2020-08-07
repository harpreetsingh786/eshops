package com.example.eshopnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class welcomeActivity extends AppCompatActivity {
    public ImageView m1,m2,m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        m1=findViewById(R.id.imageView2);
        m2=findViewById(R.id.imageView5);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done();
            }
        });
    }
    public void done()
    {
        Intent in=new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(in);
    }

}