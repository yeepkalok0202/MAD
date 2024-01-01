package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.databinding.HomeBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.example.wia2007mad.databinding.SuccessBinding;

import com.example.wia2007mad.R;

import java.util.ArrayList;

public class Success extends AppCompatActivity {


    RecyclerView successRecView;
    ImageButton btnback;;

    private SuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);

        binding= SuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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


        //button from social market page to home page
        binding.arrowleftsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}