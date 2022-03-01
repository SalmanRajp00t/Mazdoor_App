package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pagefour extends AppCompatActivity {

    TextView txt_name,txt_password,txt_email;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagefour);

        getSupportActionBar().hide();


        txt_name = findViewById(R.id.supname);
        txt_email = findViewById(R.id.supemail);
        txt_password = findViewById(R.id.suppass);

        signup= findViewById(R.id.sigup);

        Helper helper=new Helper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txt_name.getText().toString();
                String password = txt_password.getText().toString();
                String email = txt_email.getText().toString();

                if (name.equals("") || password.equals("") || email.equals("")){
                    Toast.makeText(pagefour.this,"please fill all Field",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean i=helper.checkEmail(email);
                    if (i==false){

                        boolean checkinsert=helper.insert(name,password,email);
                        Toast.makeText(pagefour.this,"Recod Save Successfully",Toast.LENGTH_SHORT).show();
                        Intent reg=new Intent(pagefour.this,pagefour.class);
                        startActivity(reg);
                    }
                    else {


                    }
                }
            }
        });




    }
}