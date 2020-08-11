package com.example.eshopnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class mobiles extends AppCompatActivity {
    EditText mobilename,mobiledescription,price;
    ImageButton imageButton;
    Button insert;
    FirebaseDatabase database;
    private int Gallary_intent=2;
    DatabaseReference ref;
    Profilemobile profilemobile;
    StorageReference imagePath;
    long maxid=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobiles);

        mobilename=findViewById(R.id.mobilename);
        mobiledescription=findViewById(R.id.imagedescription);
        price=findViewById(R.id.imgprice);
        imageButton=findViewById(R.id.imageButton);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Profilemobile");
        insert=findViewById(R.id.btnInsert);
        profilemobile=new Profilemobile();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                ref.child(String.valueOf(maxid+1)).setValue(profilemobile);

                Toast.makeText(mobiles.this,"Data Inserted..",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getValues()
    {
        profilemobile.setName(mobilename.getText().toString());
        profilemobile.setDescription(mobiledescription.getText().toString());
        profilemobile.setPrice(price.getText().toString());
        profilemobile.setImageAdress(imagePath.toString());
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
            imagePath= FirebaseStorage.getInstance().getReference().child("Profilemobile").child("images"+ UUID.randomUUID().toString());
            imagePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    System.out.println("oooooooooooooooooooooooooooooooooooo"+taskSnapshot.getStorage().getPath());
                    Toast.makeText(mobiles.this,"Uploaded...",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(mobiles.this,"Not uploaded...",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}