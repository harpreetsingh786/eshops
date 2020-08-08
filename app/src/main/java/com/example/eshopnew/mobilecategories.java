package com.example.eshopnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class mobilecategories extends AppCompatActivity {
   CardView androidCARVIEW;
   ImageView anddroidicon;
   Button androidbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilecategories);
        androidbutton=findViewById(R.id.androidibutton);

        androidbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                startActivity(intent);
            }
        });


        anddroidicon=findViewById(R.id.androidicon);

        anddroidicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                startActivity(intent);
            }
        });


androidCARVIEW=findViewById(R.id.androidcardview);

         androidCARVIEW.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            startActivity(intent);
        }
    });
    }
}