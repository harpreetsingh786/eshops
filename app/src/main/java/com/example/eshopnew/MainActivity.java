package com.example.eshopnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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


        product.add(new ProdListData("Laptops",R.drawable.macbook));
        product.add(new ProdListData("Mobiles",R.drawable.gaming));
        product.add(new ProdListData("Smart Watches",R.drawable.chrome));

        ProdListAdapter adapter=new ProdListAdapter(getApplicationContext(),product);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.back:
                DOo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void DOo()
    {
        Intent intent = new Intent(this, NavigationActivitynewone.class);
        startActivity(intent);
    }
}