package com.example.rahategoatfarming07;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Set extends AppCompatActivity {
    DrawerLayout drawerLayout;
    RelativeLayout fed,Policy,Terms,About,Log_Out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        drawerLayout = findViewById(R.id.drawer);
        fed  = findViewById(R.id.feed);
        Policy = findViewById(R.id.policy);
        Terms = findViewById(R.id.terms);
        About = findViewById(R.id.about);
        Log_Out = findViewById(R.id.out);

        fed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Set.this,Feedback.class));
            }
        });

        Policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Set.this,Policy.class));
            }
        });

        Terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Set.this,Terms.class));
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Set.this,AboutUs.class));
            }
        });


        Log_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Set.this, R.style.dialoge);
                dialog.setContentView(R.layout.dialog_layout);
                Button no, yes;
                yes = dialog.findViewById(R.id.yesbnt);
                no = dialog.findViewById(R.id.nobnt);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Set.this, SignIn.class);
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
        redirectActivity(this, Dashboard.class);

    }

    public void ClickBusinessTips(View view) {
        redirectActivity(this, BusinessTips.class);
    }
    public  void ClickSetting(View view){
        recreate();

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
        redirectActivity(this,Social_Media.class);

    }

    public void ClickShare(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Rahate Goat Farming");
        intent.setType("text/plain");

        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }

    public void ClickLogout(View view) {
        Dialog dialog = new Dialog(Set.this,R.style.dialoge);
        dialog.setContentView(R.layout.dialog_layout);
        Button no,yes;
        yes = dialog.findViewById(R.id.yesbnt);
        no = dialog.findViewById(R.id.nobnt);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Set.this, SignIn.class);
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