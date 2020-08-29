package com.example.eshopnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter_LifecycleAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;


    FirestoreRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firebaseFirestore=FirebaseFirestore.getInstance();
        mFirestoreList=findViewById(R.id.firestore_list);

        //query
        Query query=firebaseFirestore.collection("profilemobile");
        //recycleroptions

        FirestoreRecyclerOptions<ProductsModel> options=new FirestoreRecyclerOptions.Builder<ProductsModel>()
                .setQuery(query,ProductsModel.class)
                .build();

       adapter= new FirestoreRecyclerAdapter<ProductsModel, ProfileviewHolder>(options) {
            @NonNull
            @Override
            public ProfileviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new ProfileviewHolder(view);

            }

            @Override
            protected void onBindViewHolder(@NonNull ProfileviewHolder holder, int position, @NonNull ProductsModel model) {
             holder.list_description.setText(model.getDescription());
                holder.list_name.setText(model.getName());
                holder.list_price.setText(model.getPrice());
            }
        };

mFirestoreList.setHasFixedSize(true);
mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
mFirestoreList.setAdapter(adapter);
    }

    private class ProfileviewHolder extends RecyclerView.ViewHolder {

        private TextView list_description;
        private TextView list_name;
        private TextView list_price;
        public ProfileviewHolder(@NonNull View itemView) {
            super(itemView);

       list_description= itemView.findViewById(R.id.CarDesc);
            list_name= itemView.findViewById(R.id.Carname);
            list_price= itemView.findViewById(R.id.CarPrice);
        }
    }

/*
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
*/
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}