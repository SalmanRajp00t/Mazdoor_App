package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pagefour extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mconfirmpass;
    Button signup,signin;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagefour);


        mTextUsername = (EditText) findViewById(R.id.supname);
        mTextPassword = (EditText) findViewById(R.id.suppass);
        mconfirmpass =(EditText) findViewById(R.id.confirm);
        signup= (Button) findViewById(R.id.sigup);
        signin= (Button) findViewById(R.id.sigin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString();
                String pass = mTextPassword.getText().toString();
                String repss =mconfirmpass.getText().toString();

                if (user.equals("") || pass.equals("") || repss.equals(""))
                    Toast.makeText(pagefour.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repss)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(pagefour.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(pagefour.this,"Registeration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(pagefour.this,"User Already Entered",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(pagefour.this,"Password not matched",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}