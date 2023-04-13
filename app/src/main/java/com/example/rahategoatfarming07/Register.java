package com.example.rahategoatfarming07;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText signupEmail, signupUsername, signupPassword,signupconformPassword;
    TextView alreadyhaveAccount;
    Button registerButton;
    boolean passwordvisible;
    FirebaseDatabase database;
    DatabaseReference reference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signupEmail = findViewById(R.id.inputEmail);
        signupUsername = findViewById(R.id.inputUsername);
        signupPassword = findViewById(R.id.inputPassword);
        signupconformPassword = findViewById(R.id.inputConformPassword);
        registerButton = findViewById(R.id.btnRegister);
        alreadyhaveAccount = findViewById(R.id.alreadyHaveaccount);
        progressDialog = new ProgressDialog(this);

        signupconformPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX()>=signupconformPassword.getRight()-signupconformPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = signupconformPassword.getSelectionEnd();
                        if(passwordvisible){
                            signupconformPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_off_24,0);
                            signupconformPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible = false;
                        }else{
                            signupconformPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_24,0);
                            signupconformPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible = true;
                        }
                        signupconformPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });


        signupPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX()>=signupPassword.getRight()-signupPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = signupPassword.getSelectionEnd();
                        if(passwordvisible){
                            signupPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_off_24,0);
                            signupPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible = false;
                        }else{
                            signupPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_24,0);
                            signupPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible = true;
                        }
                        signupPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateSignUp()){

                }else{
                    checkUser();
                }

            }
        });

        alreadyhaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateSignUp() {
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();
        String email = signupEmail.getText().toString();
        String conformpassword = signupconformPassword.getText().toString();
        if (username.isEmpty()) {
            signupUsername.setError("Enter Username");
        }else if (!email.matches(emailPattern)) {
            signupEmail.setError("Enter Proper Pattern of Email");
        } else if (password.isEmpty()) {
            signupPassword.setError("Enter Password");
        } else if (!password.equals(conformpassword)) {
            signupconformPassword.setError("Password not match Both Field");
        } else {
            return true;
        }
        return false;
    }

    private void checkUser() {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String email = signupEmail.getText().toString();
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();
        String conformPassword = signupconformPassword.getText().toString();

        HelperClass helperClass = new HelperClass(email, username, password,conformPassword);
        reference.child(username).setValue(helperClass);

        Toast.makeText(Register.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Register.this, SignIn.class);
        startActivity(intent);
    }
}
