package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;

    Button signin,register;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextUsername = (EditText) findViewById(R.id.name);
        mTextPassword = (EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.button2);
        signin = (Button) findViewById(R.id.button);

        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString();
                String pass = mTextPassword.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this,"Please Enter all the Fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(MainActivity.this,"Sign in Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),project_1.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,pagefour.class);
                startActivity(registerIntent);
            }
        });

}

}

