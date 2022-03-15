package com.example.loginform;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listview extends AppCompatActivity {
ListView l;
    String[] country={"pakistan","india","koibhi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        l=(ListView)findViewById(R.id.list);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listviewtry,R.id.textView,country);
        l.setAdapter(adapter);

    }
}