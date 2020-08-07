package com.example.eshopnew;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    ListView simpleList;
    String countryList[] = {"Laptop1", "Laptop2", "Laptop3","Laptop14","Laptop5","Laptop16"};
    int flags[] = {R.drawable.lapi,R.drawable.lapi,R.drawable.lapi,R.drawable.lapi,R.drawable.lapi,R.drawable.lapi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        simpleList = (ListView) findViewById(R.id.simpleListView);
       CustomAdapter  customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter((ListAdapter) customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(MainActivity2.this,"One", Toast.LENGTH_LONG).show();
                }
                if(position==1)
                {

                    Toast.makeText(MainActivity2.this,"two", Toast.LENGTH_LONG).show();
                }
                if(position==2)
                {
                    Toast.makeText(MainActivity2.this,"three", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}

