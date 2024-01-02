package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.wia2007mad.R;
import com.example.wia2007mad.databinding.SuccessstoriesdetailsBinding;

public class SuccessDetailsActivity extends AppCompatActivity {

    private SuccessstoriesdetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SuccessstoriesdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("story_desc");
        String imageUrl = intent.getStringExtra("imageUrl");

        // Set data to the views
        binding.storiesdetailsname.setText(name);
        binding.storiesdetailstitle.setText(title);
        binding.storiesdetailsdesc.setText(desc);

        // Load image using Glide
        Glide.with(this)
                .load(imageUrl)
                .into(binding.storiesdetailsimage);
    }
}