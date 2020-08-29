package com.example.eshopnew;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProdListAdapter extends
        RecyclerView.Adapter<ProdListAdapter.ViewHolder> {
    ImageView myImg;
    TextView myTitle, myDesc;
    Context ctx;
    ArrayList<ProdListData> product=new ArrayList<>();
        public  ProdListAdapter(Context ctx, ArrayList<ProdListData> product){
            this.ctx=ctx;
            this.product=product;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.activity_product_category, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ProdListData prod=product.get(position);

        holder.Categoryname.setText(prod.getProdcategoryname());
        holder.imageView6.setImageResource(prod.getImgId());
        holder.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name="";
                if(prod.getProdcategoryname().equals("Laptops")){
                    name="Profile";
                }else   if(prod.getProdcategoryname().equals("Mobiles")){
                    name="profilemobile";
                }else if(prod.getProdcategoryname().equals("watches")){
                    name="Profilewatches";
                }
                Intent in=new Intent(ctx,LOPRecyclerView.class);
                in.putExtra("itms",name);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView6;
       TextView Categoryname;
       TextView prodesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView6=(ImageView) itemView.findViewById(R.id.imageView6);
            Categoryname=(TextView) itemView.findViewById(R.id.Categoryname);
        }
    }
}