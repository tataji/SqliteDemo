package com.logicshore.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydatabase {
    String result;
    sqlhelper sqlhelper;
    static class sqlhelper extends SQLiteOpenHelper {
        private static final String userreg="CREATE TABLE userreg (id VARCHAR(255) PRIMARY KEY,username VARCHAR(255),email VARCHAR(255),password VARCHAR(255));";
        private static final String name = "demo";
        private static final int version = 1;
        private Context context;
        public sqlhelper(Context context) {
            super(context, name, null, version);
            this.context = context;
        }
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(userreg);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS userreg");
            onCreate(db);
        }
    }
    public Mydatabase(Context context) {
        this.sqlhelper = new sqlhelper(context);
    }
    public long insertdata(String id, String name, String email, String password) {
        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
        ContentValues values;

        values = new ContentValues();
        values.put("id", id);

        values.put("username", name);

        values.put("email", email);
        values.put("password", password);



        long status=sd.insert("userreg", null, values);

       return status;
    }
    public Cursor getalldata()
    {
        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
        return sd.query("userreg",new String[]{"id","username","email","password"},null,null,null,null,null);
    }
}
