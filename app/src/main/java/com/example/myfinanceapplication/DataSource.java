package com.example.myfinanceapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {
    private SQLiteDatabase database;
    private DBhelper dbHelper;

    public DataSource(Context context) {
        dbHelper = new DBhelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertAccount(FinanceClass fin){
        boolean success = false;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("AccountNumber", fin.getAccountNumber());
            initialValues.put("InitialBalance", fin.getInitBalance());
            initialValues.put("CurrentBalance", fin.getCurrBalance());
            initialValues.put("PaymentAmount", fin.getPaymentAmount());
            initialValues.put("InterestRate", fin.getInterestRate());

            success = database.insert("Account", null, initialValues) > 0;
        }
        catch(Exception e){

        }
        return success;
    }
}
