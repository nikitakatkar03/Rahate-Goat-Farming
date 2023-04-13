package com.example.rahategoatfarming07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GoatDiseases extends AppCompatActivity {
    CardView Disease1,Disease2,Disease3,Disease4,Disease5,Disease6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat_diseases);

        Disease1 = findViewById(R.id.c1);
        Disease2 = findViewById(R.id.c2);
        Disease3 = findViewById(R.id.c3);
        Disease4 = findViewById(R.id.c4);
        Disease5 = findViewById(R.id.c5);
        Disease6 = findViewById(R.id.c6);

        Disease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease1.class));
            }
        });

        Disease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease2.class));
            }
        });

        Disease3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease3.class));
            }
        });

        Disease4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease4.class));
            }
        });

        Disease5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease5.class));
            }
        });

        Disease6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatDiseases.this,Disease6.class));
            }
        });

    }
}