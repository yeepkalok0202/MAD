package com.example.wia2007mad.socialmarket;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.wia2007mad.databinding.CardviewdetailspageBinding;

public class CardDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CardviewdetailspageBinding binding = CardviewdetailspageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve data from intent
        String course = getIntent().getStringExtra("course");
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        // Set data to UI elements
        binding.carddetailscourse.setText(course);
        binding.carddetailsname.setText(name);
        binding.carddetailsdesc.setText(description);

        // Load image using Glide
        Glide.with(this)
                .load(imageUrl)
                .into(binding.carddetailsimage);
    }
}
