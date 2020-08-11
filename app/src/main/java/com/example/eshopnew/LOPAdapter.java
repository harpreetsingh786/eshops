package com.example.eshopnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LOPAdapter extends
    RecyclerView.Adapter<LOPAdapter.ViewHolder>

    {
        ImageView myImg;
        TextView myTitle, myDesc;
        Context ctx;
        ArrayList<LOPpojo> product = new ArrayList<>();
        Button button;


        public LOPAdapter(Context ctx, ArrayList < LOPpojo > product) {
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
            View contactView = inflater.inflate(R.layout.productlayout, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder (@NonNull ViewHolder holder,int position){
            LOPpojo prod = product.get(position);
        // holder.imageView6.

       holder.Categoryname.setText(prod.getProdcategoryname());
        holder.prodesc.setText(prod.getProdcategorydescription());
        holder.imageView6.setImageResource(prod.getImgId());
        holder.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ctx,Listofproduct.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(i);
            }
        });

    }

        @Override
        public int getItemCount () {
        return product.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView6;
            TextView Categoryname;
            TextView prodesc;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView6 = (ImageView) itemView.findViewById(R.id.imageView6);
                Categoryname = (TextView) itemView.findViewById(R.id.Categoryname);
                prodesc = (TextView) itemView.findViewById(R.id.prodesc);
            }
        }
    }

