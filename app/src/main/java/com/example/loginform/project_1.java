package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.loginform.Addaptor.CategoryAdaptor;
import com.example.loginform.Domain.CetagoryDomain;

import java.util.ArrayList;

public class project_1 extends AppCompatActivity {
    CardView mechanic, mazdoor, plumber, electricion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project1);


        mechanic= (CardView) findViewById(R.id.mechanic);
        mechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),mechanic.class);
                startActivity(intent);
            }
        });



        mazdoor= (CardView) findViewById(R.id.mazdoor);
        mazdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),mazdoor.class);
                startActivity(intent);
            }
        });


        electricion= (CardView) findViewById(R.id.electricion);
        electricion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),electricion.class);
                startActivity(intent);
            }
        });



        plumber= (CardView) findViewById(R.id.plumber);
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),plumber.class);
                startActivity(intent);
            }
        });

    }

}