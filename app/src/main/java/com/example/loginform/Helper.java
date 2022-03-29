package com.example.loginform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable Context context) {
        super(context,"Register.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB1) {
        DB1.execSQL("create table UserTable(id integer primary key,Name Text,Password Text,Email Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB1, int i, int i1) {

        DB1.execSQL("drop table if exists UserTable");
    }
    public boolean insert(String name, String password, String email){

        SQLiteDatabase DB2=getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("Name",name);
        values.put("Password",password);
        values.put("Email",email);
        Long query=DB2.insert ("UserTable",null,values);
        if (query==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkEmail(String email){
        SQLiteDatabase DB2=getWritableDatabase();
        Cursor cursor=DB2.rawQuery("select* from UserTable where Email=?",new String[]{email});
            if (cursor.getCount()>1){
                return true;
            }
            else{
                return false;
            }
        }
    public boolean checkEmailAndPassword(String email,String password){
        SQLiteDatabase DB2=getWritableDatabase();
        Cursor cursor=DB2.rawQuery("select* from UserTable where Email=? and Password=?",new String[]{email,password});
        if (cursor.getCount()>1){
            return true;
        }
        else{

            return false;
        }
    }
}