package com.nasaspacechallenge2018.DBWork;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nasaspacechallenge2018.Database.Item;
import com.nasaspacechallenge2018.Models.ItemModel;

import java.util.ArrayList;

public class ItemTable {

    Context context;

    public static ItemTable install(Context context){
        return new ItemTable(context);
    }

    private ItemTable(Context context){
        this.context = context;
    }

    public ArrayList<ItemModel> getAll(){
        ArrayList<ItemModel> items = new ArrayList<>();

        int ID = 0;
        int SITUATION_ID = 0;
        String NAME = "";
        int REQUIRED = 0;
        String ACTION = "";
        String SYNONYM = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM ITEM", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                SITUATION_ID = cursor.getInt(cursor.getColumnIndex("SITUATION_ID"));
                NAME = cursor.getString(cursor.getColumnIndex("NAME"));
                REQUIRED = cursor.getInt(cursor.getColumnIndex("REQUIRED"));
                ACTION = cursor.getString(cursor.getColumnIndex("ACTION"));
                SYNONYM = cursor.getString(cursor.getColumnIndex("SYNONYM"));

                items.add(new ItemModel(ID, SITUATION_ID, NAME, ACTION, REQUIRED, SYNONYM));
                cursor.moveToNext();
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

    public ArrayList<ItemModel> getItemsBySituatoinId(int idSituation){
        ArrayList<ItemModel> items = new ArrayList<>();
        int ID = 0;
        int SITUATION_ID = 0;
        String NAME = "";
        int REQUIRED = 0;
        String ACTION = "";
        String SYNONYM = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM ITEM WHERE SITUATION_ID = " + idSituation, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                SITUATION_ID = cursor.getInt(cursor.getColumnIndex("SITUATION_ID"));
                NAME = cursor.getString(cursor.getColumnIndex("NAME"));
                REQUIRED = cursor.getInt(cursor.getColumnIndex("REQUIRED"));
                ACTION = cursor.getString(cursor.getColumnIndex("ACTION"));
                SYNONYM = cursor.getString(cursor.getColumnIndex("SYNONYM"));

                items.add(new ItemModel(ID, SITUATION_ID, NAME, ACTION, REQUIRED, SYNONYM));
                cursor.moveToNext();
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

    public ItemModel getById(int itemID){
        ItemModel item1 = null;

        int ID = 0;
        int SITUATION_ID = 0;
        String NAME = "";
        int REQUIRED = 0;
        String ACTION = "";
        String SYNONYM = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM ITEM WHERE ID = " + itemID, null);;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ID = cursor.getInt(cursor.getColumnIndex("ID"));
                SITUATION_ID = cursor.getInt(cursor.getColumnIndex("SITUATION_ID"));
                NAME = cursor.getString(cursor.getColumnIndex("NAME"));
                REQUIRED = cursor.getInt(cursor.getColumnIndex("REQUIRED"));
                ACTION = cursor.getString(cursor.getColumnIndex("ACTION"));
                SYNONYM = cursor.getString(cursor.getColumnIndex("SYNONYM"));

                item1 = new ItemModel(ID, SITUATION_ID, NAME, ACTION, REQUIRED, SYNONYM);
                cursor.moveToNext();
                return item1;
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

        return item1;
    }

    public ArrayList<String> getSynonymsByCategoryId(int idSituation){
        ArrayList<String> items = new ArrayList<>();
        String SYNONYM = "";

        Cursor cursor = null;
        SQLiteDatabase db = DBConnect.install(context).connect();
        try {
            cursor = db.rawQuery("SELECT * FROM ITEM WHERE SITUATION_ID = " + idSituation, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                SYNONYM = cursor.getString(cursor.getColumnIndex("SYNONYM"));
                items.add(SYNONYM);
                cursor.moveToNext();
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
