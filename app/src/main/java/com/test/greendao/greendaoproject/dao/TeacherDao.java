package com.test.greendao.greendaoproject.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.test.greendao.greendaoproject.bean.Teacher;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEACHER".
*/
public class TeacherDao extends AbstractDao<Teacher, String> {

    public static final String TABLENAME = "TEACHER";

    /**
     * Properties of entity Teacher.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Tea_id = new Property(0, String.class, "tea_id", true, "TEA_ID");
        public final static Property Tea_name = new Property(1, String.class, "tea_name", false, "TEA_NAME");
    }


    public TeacherDao(DaoConfig config) {
        super(config);
    }
    
    public TeacherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEACHER\" (" + //
                "\"TEA_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: tea_id
                "\"TEA_NAME\" TEXT);"); // 1: tea_name
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_TEACHER_TEA_ID ON \"TEACHER\"" +
                " (\"TEA_ID\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TEACHER_TEA_NAME ON \"TEACHER\"" +
                " (\"TEA_NAME\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEACHER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        String tea_id = entity.getTea_id();
        if (tea_id != null) {
            stmt.bindString(1, tea_id);
        }
 
        String tea_name = entity.getTea_name();
        if (tea_name != null) {
            stmt.bindString(2, tea_name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        String tea_id = entity.getTea_id();
        if (tea_id != null) {
            stmt.bindString(1, tea_id);
        }
 
        String tea_name = entity.getTea_name();
        if (tea_name != null) {
            stmt.bindString(2, tea_name);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public Teacher readEntity(Cursor cursor, int offset) {
        Teacher entity = new Teacher( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // tea_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // tea_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Teacher entity, int offset) {
        entity.setTea_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTea_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Teacher entity, long rowId) {
        return entity.getTea_id();
    }
    
    @Override
    public String getKey(Teacher entity) {
        if(entity != null) {
            return entity.getTea_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Teacher entity) {
        return entity.getTea_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
