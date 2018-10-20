package com.nasaspacechallenge2018;

import android.app.Application;

import com.nasaspacechallenge2018.Database.DaoMaster;
import com.nasaspacechallenge2018.Database.DaoOpenHelper;
import com.nasaspacechallenge2018.Database.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application {

    private static DaoSession daoSession;
    final private String dbname = "nasa-db";

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoOpenHelper(this, dbname, null);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
