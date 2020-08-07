package com.example.eshopnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button bt1;
    RecyclerView recyclerView;
    ArrayList<ProdListData> product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_cat_recyclerview);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);

        product=new ArrayList<ProdListData>();


        product.add(new ProdListData("hey its a description","Laptops",R.drawable.laptop));
        product.add(new ProdListData("hey its a description of mobile phone","Mobile Phones",R.drawable.laptop));
        product.add(new ProdListData("heyhey its a description of smart wartch","Smart Watches",R.drawable.laptop));
        product.add(new ProdListData("hey","b",R.drawable.laptop));

        ProdListAdapter adapter=new ProdListAdapter(getApplicationContext(),product);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       /* bt1=findViewById(R.id.Logjoinbtn);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}