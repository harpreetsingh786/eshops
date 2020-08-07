package com.example.eshopnew;


import android.content.Context;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProdListData prod=product.get(position);
       // holder.imageView6.

        holder.Categoryname.setText(prod.getProdcategoryname());
        holder.prodesc.setText(prod.getProdcategorydescription());
        holder.imageView6.setImageResource(prod.getImgId());

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
            prodesc=(TextView) itemView.findViewById(R.id.prodesc);
        }
    }
}
