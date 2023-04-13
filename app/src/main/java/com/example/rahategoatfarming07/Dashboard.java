package com.example.rahategoatfarming07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ConstraintLayout g1, g2, g3, g4, g5, g6, g7, g8,g9;
    ImageView youtube;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbaord);
        g1 = findViewById(R.id.G1);
        g2 = findViewById(R.id.G2);
        g3 = findViewById(R.id.G3);
        g4 = findViewById(R.id.G4);
        g5 = findViewById(R.id.G5);
        g6 = findViewById(R.id.G6);
        g7 = findViewById(R.id.G7);
        g8 = findViewById(R.id.G8);
        g9 = findViewById(R.id.G9);
        youtube = findViewById(R.id.Youtube);

        drawerLayout=findViewById(R.id.drawer);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.images1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images6, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images7, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.images9, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, GoatFarming.class));
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, GoatInfo.class));
            }
        });

        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, GoatFood.class));
            }
        });

        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, GoatDiseases.class));
            }
        });

        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Milk.class));
            }
        });

        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, GoatBirth.class));
            }
        });

        g7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, FarmTour.class));
            }
        });

        g8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ClickBuy.class));
            }
        });

        g9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, login.class));
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.youtube.com/@rahategoatandagrofarm");
            }
        });
    }
    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view) {
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);


        }

    }

    public void Clickhome(View view) {
        recreate();

    }

    public void ClickBusinessTips(View view) {
        redirectActivity(this, BusinessTips.class);
    }

    public void ClickContactUs(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8975529787"));
        startActivity(intent);
    }

    public void ClickLocation(View view) {
        gotoUrl("https://maps.app.goo.gl/rUYkrQFFPCfK5c7y8");
    }

    public void ClickSocialMedia(View view) {
        redirectActivity(this, Social_Media.class);
    }

    public void ClickSetting(View view) {
        redirectActivity(this, Set.class);

    }

    public void ClickShare(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Rahate Goat Farming");
        intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void ClickLogout(View view) {
        Dialog dialog = new Dialog(Dashboard.this, R.style.dialoge);
        dialog.setContentView(R.layout.dialog_layout);
        Button no, yes;
        yes = dialog.findViewById(R.id.yesbnt);
        no = dialog.findViewById(R.id.nobnt);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, SignIn.class);
                startActivity(intent);
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public static void redirectActivity(Activity activity, Class Class) {
        Intent intent = new Intent(activity, Class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}