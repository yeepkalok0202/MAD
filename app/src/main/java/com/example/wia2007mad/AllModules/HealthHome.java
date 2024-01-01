package com.example.wia2007mad.AllModules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wia2007mad.R;
import com.example.wia2007mad.databinding.ActivityHealthHomeBinding;
import com.google.android.material.button.MaterialButton;

public class HealthHome extends AppCompatActivity {

    //hello
    MaterialButton BtnChat, BtnCounselling, BtnEducation, BtnEmergency, BtnEducation2;
    private ActivityHealthHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHealthHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BtnChat = findViewById(R.id.btn_community_chatroom);
        BtnCounselling = findViewById(R.id.btn_counselling);
        BtnEducation = findViewById(R.id.btn_health_education);
        BtnEmergency = findViewById(R.id.btn_emergency_locator);
        //BtnBack = findViewById(R.id.backBtntoHome);
        BtnEducation2 = findViewById(R.id.btn_health_education_2);

        binding.backBtntoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        BtnEducation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthHome.this, HealthEducation.class));
            }
        });

        BtnEducation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthHome.this, HealthEducation.class));
            }
        });

        binding.articlecardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, webPage.class);
                String urlToLoad = "https://www.healthline.com/health/fitness-exercise/calories-burned-standing";
                intent.putExtra("url", urlToLoad);
                startActivity(intent);
            }
        });

        binding.articlecardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, webPage.class);
                String urlToLoad = "https://www.northwell.edu/katz-institute-for-womens-health/articles/womens-health-is-a-priority";
                intent.putExtra("url", urlToLoad);
                startActivity(intent);
            }
        });

        binding.articlecardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, webPage.class);
                String urlToLoad = "https://artofhealthyliving.com/natural-remedies-for-migraine-relief-during-pregnancy/";
                intent.putExtra("url", urlToLoad);
                startActivity(intent);
            }
        });
    }
}