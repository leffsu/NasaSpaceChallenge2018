package com.nasaspacechallenge2018.DBWork;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nasaspacechallenge2018.Database.Situation;
import com.nasaspacechallenge2018.Models.ItemModel;
import com.nasaspacechallenge2018.Models.SituationModel;

import java.util.ArrayList;
import java.util.List;

public class SituationTable {

    Context context;

    public static SituationTable install(Context context){
        return new SituationTable(context);
    }

    private SituationTable(Context context){
        this.context = context;
    }

    public ArrayList<SituationModel> getAll(){
        ArrayList<SituationModel> situations = new ArrayList<>();

        int ID = 0;
        String MAIN_DESCRIPTION = "";
        String COMPONENT_TEXT_BASE = "";
        int BACKGROUND = 0;
        String ERROR_MESSAGE = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM SITUATION", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                MAIN_DESCRIPTION = cursor.getString(cursor.getColumnIndex("MAIN_DESCRIPTION"));
                COMPONENT_TEXT_BASE = cursor.getString(cursor.getColumnIndex("COMPONENT_TEXT_BASE"));
                BACKGROUND = cursor.getInt(cursor.getColumnIndex("BACKGROUND"));
                ERROR_MESSAGE = cursor.getString(cursor.getColumnIndex("ERROR_MESSAGE"));

                situations.add(new SituationModel(MAIN_DESCRIPTION, COMPONENT_TEXT_BASE, BACKGROUND, ERROR_MESSAGE, ID));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();

            if (db != null)
                db.close();
        }

        return situations;
    }

    public SituationModel getSituationById(int id){
        SituationModel situation = null;

        int ID = 0;
        String MAIN_DESCRIPTION = "";
        String COMPONENT_TEXT_BASE = "";
        int BACKGROUND = 0;
        String ERROR_MESSAGE = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM SITUATION WHERE ID = " + id, null);;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                MAIN_DESCRIPTION = cursor.getString(cursor.getColumnIndex("MAIN_DESCRIPTION"));
                COMPONENT_TEXT_BASE = cursor.getString(cursor.getColumnIndex("COMPONENT_TEXT_BASE"));
                BACKGROUND = cursor.getInt(cursor.getColumnIndex("BACKGROUND"));
                ERROR_MESSAGE = cursor.getString(cursor.getColumnIndex("ERROR_MESSAGE"));


                situation = new SituationModel(MAIN_DESCRIPTION, COMPONENT_TEXT_BASE, BACKGROUND, ERROR_MESSAGE, ID);
                cursor.moveToNext();
                return situation;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();

            if (db != null)
                db.close();
        }

        return situation;
    }
}

