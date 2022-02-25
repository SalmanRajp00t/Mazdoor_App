package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class fragment extends AppCompatActivity {
     Button btnblack,btnred,btnblue,btngreen;
     LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnblack = findViewById(R.id.black);
        btnred =findViewById(R.id.red);
        btnblue =findViewById(R.id.blue);
        btngreen = findViewById(R.id.green);

        btnblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                black_Fragment blackFragment=new black_Fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout,blackFragment);
                transaction.commit();
            }
        });
        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red_Fragment redFragment=new red_Fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout,redFragment);
                transaction.commit();
            }
        });
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blue_Fragment blueFragment=new blue_Fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout,blueFragment);
                transaction.commit();
            }
        });
        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                green_Fragment greenFragment=new green_Fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout,greenFragment);
                transaction.commit();
            }
        });
    }
}