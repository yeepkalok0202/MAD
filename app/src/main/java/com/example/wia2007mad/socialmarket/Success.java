package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.R;

import java.util.ArrayList;

public class Success extends AppCompatActivity {


    RecyclerView successRecView;
    ImageButton btnback;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);

        successRecView = findViewById(R.id.successrecyclerView);
        ArrayList<SuccessData> successblog = new ArrayList<>();
        successblog.add(new SuccessData("Here are something you should know regarding how we work",   R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work", R.drawable.kunkun ));
        successblog.add(new SuccessData("Here are something you should know regarding how we work",  R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work", R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work",   R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work", R.drawable.kunkun ));
        successblog.add(new SuccessData("Here are something you should know regarding how we work",  R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work",   R.drawable.kunkun));
        successblog.add(new SuccessData("Here are something you should know regarding how we work", R.drawable.kunkun ));
        successblog.add(new SuccessData("Here are something you should know regarding how we work",  R.drawable.kunkun));


        SuccessAdapter adapter = new SuccessAdapter(this);
        adapter.setBlogs(successblog);

        successRecView.setAdapter(adapter);
        successRecView.setLayoutManager(new GridLayoutManager(this, 2));

        //add button to go back to home page
        btnback = findViewById(R.id.arrowleftsuccess);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Success.this, Home.class));
            }
        });

    }
}