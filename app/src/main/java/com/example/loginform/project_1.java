package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.loginform.Addaptor.CategoryAdaptor;
import com.example.loginform.Domain.CetagoryDomain;

import java.util.ArrayList;

public class project_1 extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project1);

        recyclerViewCategory();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CetagoryDomain> cetagory=new ArrayList<>();
        cetagory.add(new CetagoryDomain("pizza","cat_1"));
        cetagory.add(new CetagoryDomain("mazdoor","cat_2"));
        cetagory.add(new CetagoryDomain("mistry","cat_3"));
        cetagory.add(new CetagoryDomain("plumber","cat_4"));

        adapter=new CategoryAdaptor(cetagory);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}