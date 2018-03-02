package com.logicshore.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mydatabase database=new Mydatabase(this);
        long status=database.insertdata("4","asdfsdf","asdf.c","1234567");
        int count=database.getalldata().getCount();
        Toast.makeText(getApplicationContext(),count+"",Toast.LENGTH_SHORT).show();
        Cursor c=database.getalldata();
        while (c.moveToNext())
        {
            Log.d("username",c.getString(1));
        }
    }
}
