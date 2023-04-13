package com.example.rahategoatfarming07;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText loginUsername, loginPassword;
    boolean passwordvisible;
    public static String PREFS_NAME = "MyPrefsFile";
    Button loginButton;
    TextView ForgotPassword,createnewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        loginUsername = findViewById(R.id.inputUsername);
        loginPassword = findViewById(R.id.inputPassword);
        ForgotPassword = findViewById(R.id.forgotPassword);
        loginButton = findViewById(R.id.btnLogin);
        createnewAccount = findViewById(R.id.createNewAccount);

        loginPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX()>=loginPassword.getRight()-loginPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = loginPassword.getSelectionEnd();
                        if(passwordvisible){
                            loginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_off_24,0);
                            loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible = false;
                        }else{
                            loginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_24,0);
                            loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible = true;
                        }
                        loginPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()){

                } else {
                    checkUser();
                }

                SharedPreferences sharedPreferences = getSharedPreferences(SignIn.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean("hasLoggedIn",true);
                editor.commit();

                startActivity(new Intent(SignIn.this,Profile.class));
                finish();
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Register.class);
                startActivity(intent);
            }
        });

        createnewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Register.class);
                startActivity(intent);
            }
        });
    }



    public Boolean validateUsername(){
        String val = loginUsername.getText().toString();
        if (val.isEmpty()){
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()){
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)){
                        loginUsername.setError(null);

                        //Pass the data using intent

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);

                        Toast.makeText(SignIn.this, "You have login successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn.this,Profile.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);

                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Password");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}