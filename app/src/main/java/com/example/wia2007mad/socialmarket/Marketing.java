package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.widget.SearchView.OnQueryTextListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.AllModules.webViewPage;
import com.example.wia2007mad.databinding.SuccessBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import com.example.wia2007mad.databinding.MarketingBinding;
import com.example.wia2007mad.R;

import java.util.ArrayList;
import java.util.List;

public class Marketing extends AppCompatActivity {

    RecyclerView recyclerView;
    MarketAdapter adapter;
    //ArrayList<String> items;

    ArrayList<MarketData> marketresourcelist;
    private MarketingBinding binding;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketing);

        binding= MarketingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        /*
        MarketData[] marketData = new MarketData[]{
                new MarketData("test1", "test1", "test1", R.drawable.kunkun)};

         */

        /*
        items = new ArrayList<>();
        items.add("First");
         */

        /*
        adapter = new MarketAdapter(this,items );
        recyclerView.setAdapter(adapter);

         */

        //adapter = new MarketAdapter(marketData,this );
        //new
        adapter = new MarketAdapter(this);
        recyclerView.setAdapter(adapter);


        //firebase
        marketresourcelist = new ArrayList<>();
        //firebase code
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("marketing_resource")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            MarketData marketdata = new MarketData();
                            marketdata.name = document.getString("name");
                            marketdata.imageUrl = document.getString("image");
                            marketdata.course = document.getString("course");
                            marketdata.marketDesc = document.getString("market_desc");
                            marketdata.url = document.getString("url");
                            marketresourcelist.add(marketdata);
                        }
                        adapter.setResources(marketresourcelist);
                    }


                });


        //button from marketing page to home page
        binding.arrowleftmarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //searchview


    }

}