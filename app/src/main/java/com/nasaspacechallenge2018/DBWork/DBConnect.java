package com.nasaspacechallenge2018.DBWork;

import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

public class DBConnect {
    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;
    private Context activity;

    public static DBConnect install(Context activity) {
        return new DBConnect(activity);
    }

    public DBConnect(Context activity) {
        this.activity = activity;
    }

    public SQLiteDatabase connect() {
        if (mDBHelper == null)
            mDBHelper = new DBHelper(activity);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        return mDb;
    }
}