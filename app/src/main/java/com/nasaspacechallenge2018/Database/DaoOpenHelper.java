package com.nasaspacechallenge2018.Database;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import static com.nasaspacechallenge2018.Database.DaoMaster.dropAllTables;

public class DaoOpenHelper extends DaoMaster.DevOpenHelper {
    private Context context;

    public DaoOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
        this.context = context;
    }

    public DaoOpenHelper(Context context, String name) {
        super(context, name);
        this.context = context;
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.d("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");

        // Reset data about all loaded maps
        SharedPreferences sPref = context.getSharedPreferences("metro", Context.MODE_PRIVATE);

        int mapId = sPref.getInt("mapId", -1);
        SharedPreferences.Editor editor = sPref.edit();
        editor.clear();
        if (mapId != -1) {
            editor.putInt("mapId", mapId);
        }
        editor.apply();
        //editor.putBoolean("db_migration", true).apply();

        migration(db, oldVersion, newVersion);
    }

    private void migration(Database db, int oldVersion, int newVersion) {
        Log.d("MIGRATION_DB", "new ver. - " + newVersion);
        dropAllTables(db, true);
        onCreate(db);
    }
}
