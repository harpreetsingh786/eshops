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
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class LOPRecyclerView extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reff;
    LOPAdapter lopAdapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_p_recycler_view);

        db = FirebaseFirestore.getInstance();
        Intent in = getIntent();
        String val = in.getStringExtra("itms");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewitems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Profile> prodlist = new ArrayList<>();


        if (val.equals("Profile")) {
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

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if (val.equals("profilemobile")) {
            final DatabaseReference db = FirebaseDatabase.getInstance().getReference("profilemobile");

            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                            Profile l = npsnapshot.getValue(Profile.class);
                            prodlist.add(l);
                        }
                        lopAdapter = new LOPAdapter(getApplicationContext(), prodlist);

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
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

                        recyclerView.setAdapter(lopAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back, menu);
        return true;
    }
}