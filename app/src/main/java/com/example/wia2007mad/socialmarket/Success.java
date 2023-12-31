package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

        /*
        ArrayList<SuccessData> successblog = new ArrayList<>();
        successblog.add(new SuccessData("Here are something you should know regarding how we work",   R.drawable.kunkun));
         */

        SuccessAdapter adapter = new SuccessAdapter(this);
        //adapter.setBlogs(successblog);

        successRecView.setAdapter(adapter);
        successRecView.setLayoutManager(new GridLayoutManager(this, 2));

        //firebase
        ArrayList<SuccessData> successblog = new ArrayList<>();

        //firebase code
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("success_stories")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            SuccessData successData = new SuccessData();
                            successData.imageUrl = document.getString("image");
                            successData.successtext = document.getString("title");
                            successData.url = document.getString("url");
                            successblog.add(successData);
                        }
                        adapter.setBlogs(successblog);
                    }



                });


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