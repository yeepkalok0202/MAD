package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.databinding.BusinessBinding;

import com.example.wia2007mad.R;

import com.example.wia2007mad.AllModules.webViewPage;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;
import java.util.List;

public class Business extends AppCompatActivity {

    //RecyclerView recyclerView;
    BusinessAdapter adapter;
    ImageButton btnback;

    List<BusinessData> businessDataList = new ArrayList<>();
    private BusinessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business);

        binding= BusinessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set layout
        //binding.businessrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //but dont need this when xml file already set layout

        getBusinessData();

        binding.businesssearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterData(newText);
                return true;
            }
        });

        /*
        recyclerView = findViewById(R.id.businessrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BusinessData[] businessData = new BusinessData[]{
                new BusinessData("test111", "test1", "test1", R.drawable.kunkun),
                new BusinessData("test222", "test2", "test2", R.drawable.kunkun),

        };

        adapter = new BusinessAdapter(businessData,this );
        recyclerView.setAdapter(adapter);



         */
        //button from business page to home page
        binding.arrowleftbusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void getBusinessData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("business_planning")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            BusinessData businessData = new BusinessData();
                            businessData.name = document.getString("name");
                            businessData.imageUrl = document.getString("image");
                            businessData.course = document.getString("course");
                            businessData.businessDesc = document.getString("business_desc");
                            businessData.url = document.getString("url");
                            businessDataList.add(businessData);

                        }
                        if (businessDataList.size() > 0) {
                            BusinessAdapter businessAdapter = new BusinessAdapter(businessDataList, new BusinessListener() {
                                @Override
                                public void onItemClicked(BusinessData businessData) {
                                    Intent intent = new Intent(getApplicationContext(), webViewPage.class);
                                    intent.putExtra("url", businessData.url);
                                    startActivity(intent);
                                }
                            });
                            binding.businessrecyclerView.setAdapter(businessAdapter);
                        }
                    }
                });
    }

    private void filterData(String query) {
        List<BusinessData> filteredList = new ArrayList<>();
        for (BusinessData businessData : businessDataList) {
            if (businessData.course.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(businessData);
            }
        }

        BusinessAdapter businessAdapter = new BusinessAdapter(filteredList, new BusinessListener() {
            @Override
            public void onItemClicked(BusinessData businessData) {
                Intent intent = new Intent(getApplicationContext(), webViewPage.class);
                intent.putExtra("url", businessData.url);
                startActivity(intent);
            }
        });
        binding.businessrecyclerView.setAdapter(businessAdapter);
    }
}