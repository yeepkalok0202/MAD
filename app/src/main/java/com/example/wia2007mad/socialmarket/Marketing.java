package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.R;

public class Marketing extends AppCompatActivity {

    RecyclerView recyclerView;
    MarketAdapter adapter;
    //ArrayList<String> items;

    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketing);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MarketData[] marketData = new MarketData[]{
                new MarketData("test1", "test1", "test1", R.drawable.kunkun),
                new MarketData("test2", "test2", "test2", R.drawable.kunkun),
                new MarketData("test3", "test3", "test3", R.drawable.kunkun),
                new MarketData("test4", "test4", "test4", R.drawable.ic_launcher_background),
                new MarketData("test5", "test5", "test5", R.drawable.ic_launcher_background),

        };
        /*
        items = new ArrayList<>();
        items.add("First");
        items.add("Second");
        items.add("Third");
        items.add("Forth");
        items.add("Fifth");
         */


        /*
        adapter = new MarketAdapter(this,items );
        recyclerView.setAdapter(adapter);

         */

        adapter = new MarketAdapter(marketData,this );
        recyclerView.setAdapter(adapter);

        //add button to go back to home page
        btnback = findViewById(R.id.arrowleftmarket);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Marketing.this, Home.class));
            }
        });


    }
}