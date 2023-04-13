package com.example.rahategoatfarming07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GoatInfo extends AppCompatActivity {

    CardView goat1,goat2,goat3,goat4,goat5,goat6,goat7,goat8,goat9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat_info);

        goat1 = findViewById(R.id.c1);
        goat2 = findViewById(R.id.c2);
        goat3 = findViewById(R.id.c3);
        goat4 = findViewById(R.id.c4);
        goat5 = findViewById(R.id.c5);
        goat6 = findViewById(R.id.c6);
        goat7 = findViewById(R.id.c7);
        goat8 = findViewById(R.id.c8);
        goat9 = findViewById(R.id.c9);

        goat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat1.class));
            }
        });

        goat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat2.class));
            }
        });

        goat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat3.class));
            }
        });

        goat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat7.class));
            }
        });

        goat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat4.class));
            }
        });

        goat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat5.class));
            }
        });

        goat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat6.class));
            }
        });

        goat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat8.class));
            }
        });

        goat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatInfo.this,Goat9.class));
            }
        });
    }
}