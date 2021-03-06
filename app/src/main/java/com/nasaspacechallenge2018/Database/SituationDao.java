package com.nasaspacechallenge2018.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SITUATION".
*/
public class SituationDao extends AbstractDao<Situation, Integer> {

    public static final String TABLENAME = "SITUATION";

    /**
     * Properties of entity Situation.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", true, "ID");
        public final static Property MainDescription = new Property(1, String.class, "mainDescription", false, "MAIN_DESCRIPTION");
        public final static Property ComponentTextBase = new Property(2, String.class, "componentTextBase", false, "COMPONENT_TEXT_BASE");
        public final static Property Background = new Property(3, int.class, "background", false, "BACKGROUND");
        public final static Property ErrorMessage = new Property(4, String.class, "errorMessage", false, "ERROR_MESSAGE");
    }


    public SituationDao(DaoConfig config) {
        super(config);
    }
    
    public SituationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SITUATION\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"MAIN_DESCRIPTION\" TEXT," + // 1: mainDescription
                "\"COMPONENT_TEXT_BASE\" TEXT," + // 2: componentTextBase
                "\"BACKGROUND\" INTEGER NOT NULL ," + // 3: background
                "\"ERROR_MESSAGE\" TEXT);"); // 4: errorMessage
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SITUATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Situation entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String mainDescription = entity.getMainDescription();
        if (mainDescription != null) {
            stmt.bindString(2, mainDescription);
        }
 
        String componentTextBase = entity.getComponentTextBase();
        if (componentTextBase != null) {
            stmt.bindString(3, componentTextBase);
        }
        stmt.bindLong(4, entity.getBackground());
 
        String errorMessage = entity.getErrorMessage();
        if (errorMessage != null) {
            stmt.bindString(5, errorMessage);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Situation entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String mainDescription = entity.getMainDescription();
        if (mainDescription != null) {
            stmt.bindString(2, mainDescription);
        }
 
        String componentTextBase = entity.getComponentTextBase();
        if (componentTextBase != null) {
            stmt.bindString(3, componentTextBase);
        }
        stmt.bindLong(4, entity.getBackground());
 
        String errorMessage = entity.getErrorMessage();
        if (errorMessage != null) {
            stmt.bindString(5, errorMessage);
        }
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.getInt(offset + 0);
    }    

    @Override
    public Situation readEntity(Cursor cursor, int offset) {
        Situation entity = new Situation( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // mainDescription
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // componentTextBase
            cursor.getInt(offset + 3), // background
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // errorMessage
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Situation entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setMainDescription(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setComponentTextBase(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBackground(cursor.getInt(offset + 3));
        entity.setErrorMessage(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Integer updateKeyAfterInsert(Situation entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public Integer getKey(Situation entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Situation entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
