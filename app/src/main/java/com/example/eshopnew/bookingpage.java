package com.example.eshopnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class bookingpage extends AppCompatActivity {
    public Button bt1;
    public EditText ed1,ed2,ed3,ed4,ed5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingpage);
        bt1=findViewById(R.id.submit);
        ed1=findViewById(R.id.firstname);
        ed2=findViewById(R.id.lastname);
        ed3=findViewById(R.id.email);
        ed4=findViewById(R.id.phonenumber);
        ed5=findViewById(R.id.phonenumberd);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}