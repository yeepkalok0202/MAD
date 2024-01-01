package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.databinding.BusinessBinding;

import com.example.wia2007mad.R;
import com.example.wia2007mad.databinding.SuccessBinding;

public class Business extends AppCompatActivity {

    RecyclerView recyclerView;
    BusinessAdapter adapter;
    ImageButton btnback;

    private BusinessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business);

        binding= BusinessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.businessrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BusinessData[] businessData = new BusinessData[]{
                new BusinessData("test111", "test1", "test1", R.drawable.kunkun),
                new BusinessData("test222", "test2", "test2", R.drawable.kunkun),
                new BusinessData("test333", "test3", "test3", R.drawable.kunkun),
                new BusinessData("test444", "test4", "test4", R.drawable.ic_launcher_background),
                new BusinessData("test555", "test5", "test5", R.drawable.ic_launcher_background),

        };

        adapter = new BusinessAdapter(businessData,this );
        recyclerView.setAdapter(adapter);


        //button from business page to home page
        binding.arrowleftbusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}