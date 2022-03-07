package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log =findViewById(R.id.button);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign=new Intent(MainActivity.this , pagefour.class);
                startActivity(sign);
                Toast.makeText(MainActivity.this, "Arslan ", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().hide();

    }
}