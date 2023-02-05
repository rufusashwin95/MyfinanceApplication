package com.example.myfinanceapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper
{
    private static final String DBName = "myfinances.db";
    private static final int DB_VERSION = 1;

    //Database creation
    private static final String CREATE_TABLE_ACCOUNT = "" +
            "create table Account (_id integer primary key autoincrement,"
            + "AccountNumber number not null, InitialBalance number, CurrentBalance number, "
            + "PaymentAmount number, InterestRate number);";

    public DBhelper(Context context) {
        super(context, DBName, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ACCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBhelper.class.getName(),
                "Upgrading database from version" + oldVersion + "to"
                        + newVersion + ",which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contact");
    }
}