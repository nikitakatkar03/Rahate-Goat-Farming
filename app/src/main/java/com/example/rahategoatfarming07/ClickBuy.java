package com.example.rahategoatfarming07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ClickBuy extends AppCompatActivity {

    TextView H1,H2,H3,H4,H5,J1,J2,J3,J4,J5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_buy);
        H1 = findViewById(R.id.h1);
        H2 = findViewById(R.id.h2);
        H3 = findViewById(R.id.h3);
        H4 = findViewById(R.id.h4);
        H5 = findViewById(R.id.h5);

        J1 = findViewById(R.id.j1);
        J2 = findViewById(R.id.j2);
        J3 = findViewById(R.id.j3);
        J4 = findViewById(R.id.j4);
        J5 = findViewById(R.id.j5);

        H1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        H2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        H3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        H4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        H5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        J1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        J2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        J3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        J4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });

        J5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickBuy.this,Scanner.class));
            }
        });
    }
}