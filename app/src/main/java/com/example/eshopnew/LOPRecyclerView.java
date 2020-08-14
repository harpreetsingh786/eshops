package com.example.eshopnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LOPRecyclerView extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reff;
    LOPAdapter lopAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_p_recycler_view);


                Intent in =getIntent();
                String val=in.getStringExtra("itms");
            //    String items=in.get
            recyclerView=(RecyclerView) findViewById(R.id.recyclerviewitems );
            recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final ArrayList<Profile> prodlist = new ArrayList<>();

        if(val.equals("Profile")) {
            final DatabaseReference db = FirebaseDatabase.getInstance().getReference("Profile");

            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                            Profile l = npsnapshot.getValue(Profile.class);
                            prodlist.add(l);
                        }
                        lopAdapter = new LOPAdapter(getApplicationContext(), prodlist);
                        //  adapter=new MyAdapter(listData);
                        //     rv.setAdapter(adapter);

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else if(val.equals("Profilemobile")){
            final DatabaseReference db = FirebaseDatabase.getInstance().getReference("Profilemobile");

            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                            Profile l = npsnapshot.getValue(Profile.class);
                            prodlist.add(l);
                        }
                        lopAdapter = new LOPAdapter(getApplicationContext(), prodlist);
                        //  adapter=new MyAdapter(listData);
                        //     rv.setAdapter(adapter);

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else{
            final DatabaseReference db = FirebaseDatabase.getInstance().getReference("Profilewatches");

            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                            Profile l = npsnapshot.getValue(Profile.class);
                            prodlist.add(l);
                        }
                        lopAdapter = new LOPAdapter(getApplicationContext(), prodlist);
                        //  adapter=new MyAdapter(listData);
                        //     rv.setAdapter(adapter);

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
          /*  if(val.equals("Laptops")){
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

            }*/



        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.back, menu);
            return true;
        }
    }