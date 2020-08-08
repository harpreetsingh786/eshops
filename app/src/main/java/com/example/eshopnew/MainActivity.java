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


        product.add(new ProdListData("The MacBook is a line of Macintosh laptop computers designed by Apple. The MacBook line consists of the original MacBook (2006-present), the MacBook Pro (2006-present), and the MacBook Air (2008-present). The MacBook lineup came from the merging of the PowerBook and iBook lines as Apple transitioned over to using Intel instead of PowerPC processors.","Macbooks",R.drawable.macbook));
        product.add(new ProdListData("A gaming computer, also known as a gaming PC or gaming rig, is a personal computer designed for playing video games that require a high amount of computing power.","Gaming Laptops",R.drawable.gaming));
        product.add(new ProdListData("Chromebooks are lightweight laptops that heavily depend on Google Chrome. While you have OS-specific features like a file manager, app launcher, taskbar, and so on, most of your work and play resides within a Chrome tab.","Chrome Laptops",R.drawable.chrome));

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