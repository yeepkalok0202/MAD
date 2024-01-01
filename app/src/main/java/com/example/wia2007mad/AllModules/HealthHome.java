package com.example.wia2007mad.AllModules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.wia2007mad.R;
import com.example.wia2007mad.databinding.ActivityHealthHomeBinding;

public class HealthHome extends AppCompatActivity {

    private ActivityHealthHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHealthHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtntoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}