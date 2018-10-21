package com.nasaspacechallenge2018.DBWork;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nasaspacechallenge2018.Models.SituationModel;
import com.nasaspacechallenge2018.Models.SubSituationModel;

import java.util.ArrayList;

public class SubSituationTable {

    Context context;

    public static SubSituationTable install(Context context){
        return new SubSituationTable(context);
    }

    private SubSituationTable(Context context){
        this.context = context;
    }

    public ArrayList<SubSituationModel> getSubSituationBySituationId(int situationId){
        ArrayList<SubSituationModel> subSituationModels = new ArrayList<>();

        int ID = 0;
        String TITLE_SUB_SITUATION = "";
        String SYNONYM_SUB_SITUATION = "";
        int ID_SITUATION = 0;
        int BACKGROUND_SUB_SITUATION = 0;
        String DISCRIBE_SUB_SITUATION = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM SUB_SITUACION WHERE ID_SITUATION = " + situationId, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                TITLE_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("TITLE_SUB_SITUATION"));
                SYNONYM_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("SYNONYM_SUB_SITUATION"));
                ID_SITUATION = cursor.getInt(cursor.getColumnIndex("ID_SITUATION"));
                BACKGROUND_SUB_SITUATION = cursor.getInt(cursor.getColumnIndex("BACKGROUND_SUB_SITUATION"));
                DISCRIBE_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("DISCRIBE_SUB_SITUATION"));

                subSituationModels.add(new SubSituationModel(ID, TITLE_SUB_SITUATION, SYNONYM_SUB_SITUATION, ID_SITUATION, BACKGROUND_SUB_SITUATION, DISCRIBE_SUB_SITUATION));
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

        return subSituationModels;
    }

    public SubSituationModel getSynonymsBySubSituationId(int idSub){
        SubSituationModel items = null;
        int ID = 0;
        String TITLE_SUB_SITUATION = "";
        String SYNONYM_SUB_SITUATION = "";
        int ID_SITUATION = 0;
        int BACKGROUND_SUB_SITUATION = 0;
        String DISCRIBE_SUB_SITUATION = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM SUB_SITUACION WHERE ID = " + idSub, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                TITLE_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("TITLE_SUB_SITUATION"));
                SYNONYM_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("SYNONYM_SUB_SITUATION"));
                ID_SITUATION = cursor.getInt(cursor.getColumnIndex("ID_SITUATION"));
                BACKGROUND_SUB_SITUATION = cursor.getInt(cursor.getColumnIndex("BACKGROUND_SUB_SITUATION"));
                DISCRIBE_SUB_SITUATION = cursor.getString(cursor.getColumnIndex("DISCRIBE_SUB_SITUATION"));

                items = new SubSituationModel(ID, TITLE_SUB_SITUATION, SYNONYM_SUB_SITUATION, ID_SITUATION, BACKGROUND_SUB_SITUATION, DISCRIBE_SUB_SITUATION);
                cursor.moveToNext();
                return items;
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();

            if (db != null)
                db.close();
        }
        return items;
    }
}
