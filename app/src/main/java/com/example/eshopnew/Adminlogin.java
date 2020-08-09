package com.example.eshopnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Adminlogin extends AppCompatActivity {

    EditText AdminpasswordediText,AdminEmailIdediText;
    Button AdminSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);


        AdminpasswordediText=(EditText)findViewById(R.id.LogpasswordeditText);
        AdminEmailIdediText=(EditText)findViewById(R.id.LogEmaileditText);


        AdminSignUp=(Button)findViewById(R.id.Logjoinbtn);

        AdminSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (AdminEmailIdediText.getText().toString().equals("admin")&&AdminpasswordediText.getText().toString().equals("admin"))

                {
                    Intent intent=new Intent(Adminlogin.this,adminwelcomeactivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Adminlogin.this,"Login Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}