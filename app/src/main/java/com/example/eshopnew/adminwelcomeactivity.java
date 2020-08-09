package com.example.eshopnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminwelcomeactivity extends AppCompatActivity {

    Button LAPTOPS,mobile,watches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminwelcomeactivity);


    LAPTOPS=findViewById(R.id.laptop);
    mobile=findViewById(R.id.mobile);
    watches=findViewById(R.id.watches);


LAPTOPS.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(adminwelcomeactivity.this,laptops.class);
        startActivity(intent);
    }
});

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(adminwelcomeactivity.this,mobiles.class);
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(adminwelcomeactivity.this,watches.class);
                startActivity(intent);
            }
        });




    }
}