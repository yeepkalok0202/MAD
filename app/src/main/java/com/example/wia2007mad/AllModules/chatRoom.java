package com.example.wia2007mad.AllModules;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wia2007mad.R;

public class chatRoom extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton backBtn;

    EditText chatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        backBtn = findViewById(R.id.BtnBackFromChat);
        toolbar = findViewById(R.id.toolbar);
        chatBox = findViewById(R.id.chatBox);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(chatRoom.this, CommunityChatroom.class));
            }
        });
    }


}