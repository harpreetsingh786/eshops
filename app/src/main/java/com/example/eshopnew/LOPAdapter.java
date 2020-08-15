package com.example.eshopnew;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LOPAdapter extends
    RecyclerView.Adapter<LOPAdapter.ViewHolder>

    {
        ImageView myImg;
        TextView myTitle, myDesc;
        Context ctx;
        ArrayList<Profile> product = new ArrayList<>();
        Button button;


        public LOPAdapter(Context ctx, ArrayList < Profile > product) {
        this.ctx = ctx;
        this.product = product;

    }

        @NonNull
        @Override
        public LOPAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
        {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.activity_listofproduct, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder (@NonNull final ViewHolder holder, int position){
            Profile prod = product.get(position);
        // holder.imageView6.

       holder.laptopname.setText(prod.getName());
        holder.laptopdesc.setText(prod.getDescription());
        holder.laptoprice.setText(prod.getPrice());

            FirebaseStorage firebaseStorage= FirebaseStorage.getInstance();
            StorageReference str=firebaseStorage.getReferenceFromUrl(prod.getImageAdress());
            str.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    Glide.with(ctx)
                            .load(uri.toString())
                            .into(holder.laptopimage);
                }
            });

            holder.laptopbuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in =new Intent(ctx,Advertisement.class);
                    in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(in);
                }
            });

    }

        @Override
        public int getItemCount () {
        return product.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView laptopimage;
            TextView laptopname;
            TextView laptopdesc;
            TextView laptoprice;
            Button  laptopbuy;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                laptopimage = (ImageView) itemView.findViewById(R.id.laptopimage);
                laptopname = (TextView) itemView.findViewById(R.id.laptopname);
                laptopdesc = (TextView) itemView.findViewById(R.id.laptopdesc);
                laptoprice=(TextView)itemView.findViewById(R.id.laptoprice);
                laptopbuy=(Button) itemView.findViewById(R.id.laptopbuy);
            }
        }
    }

