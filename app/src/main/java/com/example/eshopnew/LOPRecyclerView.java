package com.example.eshopnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class LOPRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_p_recycler_view);
        RecyclerView recyclerView;
        ArrayList<LOPpojo> product;


                Intent in =getIntent();
                String val=in.getStringExtra("itms");
            //    String items=in.get
            recyclerView=(RecyclerView) findViewById(R.id.recyclerviewitems );

            product=new ArrayList<LOPpojo>();


            if(val.equals("Laptops")){
                product.add(new LOPpojo("Take your productivity anywhere with the HP laptop. This 15.6\" machine features a sleek and portable design with a micro-edge bezel and precision touchpad. It comes with a 1.3GHz Intel quad-core processor, 8GB of RAM, a 512GB solid state drive, and a long-life battery to give you the power you need to get everything done.", "Laptop 1", R.drawable.macbook));
                product.add(new LOPpojo("A gaming computer, also known as a gaming PC or gaming rig, is a personal computer designed for playing video games that require a high amount of computing power.", "Laptop 2", R.drawable.gaming));
                product.add(new LOPpojo("Chromebooks are lightweight laptops that heavily depend on Google Chrome. While you have OS-specific features like a file manager, app launcher, taskbar, and so on, most of your work and play resides within a Chrome tab.", " Laptop 3", R.drawable.chrome));

            }else if(val.equals("Mobiles")){
                product.add(new LOPpojo("Description of mobile 1", "Mobile 1", R.drawable.mobile1));
                product.add(new LOPpojo("Description of mobile 2", "Mobile 2", R.drawable.mobile2));
                product.add(new LOPpojo("Description of mobile 3", " Mobile 3", R.drawable.mobile3));

            }else {

                product.add(new LOPpojo("Description of smart watch 1", "Smart watch 1", R.drawable.sm1));
                product.add(new LOPpojo("Description of smart watch 2", "Smamrt Watch 2", R.drawable.sm2));
                product.add(new LOPpojo("Description of smart watch 3", " Smart watch 3", R.drawable.sm3));

            }

        LOPAdapter adapter = new LOPAdapter(getApplicationContext(), product);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.back, menu);
            return true;
        }
    }