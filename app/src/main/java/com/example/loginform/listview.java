package com.example.loginform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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