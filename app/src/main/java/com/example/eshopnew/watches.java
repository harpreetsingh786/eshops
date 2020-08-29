package com.example.eshopnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class watches extends AppCompatActivity {
    EditText watchname,watchdescription,price;
    ImageButton imageButton;
    Button insert;
    FirebaseDatabase database;
    private int Gallary_intent=2;
    DatabaseReference ref;
    Profilewatches profilewatches;
    StorageReference imagePath;
    long maxid=0;
private  FirebaseFirestore dbfirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches);

        watchname=findViewById(R.id.watchesname);
        watchdescription=findViewById(R.id.imagedescription);
        price=findViewById(R.id.imgprice);
        imageButton=findViewById(R.id.imageButton);
        database=FirebaseDatabase.getInstance();

        insert=findViewById(R.id.btnInsert);
        profilewatches=new Profilewatches();
        dbfirestore= FirebaseFirestore.getInstance();



        profilewatches=new Profilewatches();

        insert.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                getValues();

                int random = ThreadLocalRandom.current().nextInt(1, 1000);

                dbfirestore.collection("profilewatches").document(String.valueOf(random))
                        .set(profilewatches)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                Log.d("TAG", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error writing document", e);
                            }
                        });
                dbfirestore.collection("profilewatches").document(String.valueOf(maxid)).set(profilewatches);
                //    ref.child(String.valueOf(maxid+1)).setValue(profilemobile);

                Toast.makeText(watches.this,"Data Inserted..",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getValues()
    {
        profilewatches.setName(watchname.getText().toString());
        profilewatches.setDescription(watchdescription.getText().toString());
        profilewatches.setPrice(price.getText().toString());
        profilewatches.setImageAdress(imagePath.toString());
    }


    public void btnImage(View view)
    {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,Gallary_intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==Gallary_intent && resultCode==RESULT_OK)
        {
            Uri uri= data.getData();
            imageButton.setImageURI(uri);
            imagePath= FirebaseStorage.getInstance().getReference().child("profilewatches").child("images"+ UUID.randomUUID().toString());
            imagePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    System.out.println("oooooooooooooooooooooooooooooooooooo"+taskSnapshot.getStorage().getPath());
                    Toast.makeText(watches.this,"Uploaded...",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(watches.this,"Not uploaded...",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}