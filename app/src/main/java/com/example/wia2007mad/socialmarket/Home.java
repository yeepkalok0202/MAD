package com.example.wia2007mad.socialmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wia2007mad.R;

public class Home extends AppCompatActivity {

    ImageButton successarrow, marketarrow;

    Button businessreadmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //arrow from home page to success
        successarrow = findViewById(R.id.sucessarrow);
        successarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Success.class));
            }
        });

        //arrow from home page to market
        marketarrow = findViewById(R.id.marketingarrow);
        marketarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Marketing.class));
            }
        });

        //button from home page to business
        businessreadmore = findViewById(R.id.businessreadmore);
        businessreadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Business.class));
            }
        });
    }
}