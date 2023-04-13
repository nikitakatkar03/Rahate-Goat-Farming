package com.example.rahategoatfarming07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GoatFarming extends AppCompatActivity {
    TextView f1,f2,f3,f4,f5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat_farming);
        f1 = findViewById(R.id.F1);
        f2 = findViewById(R.id.F2);
        f3 = findViewById(R.id.F3);
        f4 = findViewById(R.id.F4);
        f5 = findViewById(R.id.F5);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatFarming.this,Farming1.class));
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatFarming.this,Farming2.class));
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatFarming.this,Farming3.class));
            }
        });

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatFarming.this,Farming4.class));
            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoatFarming.this,Farming5.class));
            }
        });
    }
}