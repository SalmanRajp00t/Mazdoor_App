package com.example.loginform;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
     black_Fragment blackFragment=new black_Fragment();
     blue_Fragment blueFragment =new blue_Fragment();
     green_Fragment greenFragment = new green_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,blackFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.black:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,blackFragment).commit();
                    return true;
                case R.id.blue:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,blueFragment).commit();
                    return true;
                case R.id.green:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,greenFragment).commit();
                    return true;
            }

            return false;
        });
        getSupportActionBar().hide();
    }
}