package com.xiaojun.yiliaoxitong.beans;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DENG_LU_BEAN".
*/
public class DengLuBeanDao extends AbstractDao<DengLuBean, Long> {

    public static final String TABLENAME = "DENG_LU_BEAN";

    /**
     * Properties of entity DengLuBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Zhuji = new Property(1, String.class, "zhuji", false, "ZHUJI");
        public final static Property Username = new Property(2, String.class, "username", false, "USERNAME");
        public final static Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public final static Property Token = new Property(4, String.class, "token", false, "TOKEN");
        public final static Property Zhuzhiyisheng = new Property(5, String.class, "zhuzhiyisheng", false, "ZHUZHIYISHENG");
    }


    public DengLuBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DengLuBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DENG_LU_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"ZHUJI\" TEXT," + // 1: zhuji
                "\"USERNAME\" TEXT," + // 2: username
                "\"PASSWORD\" TEXT," + // 3: password
                "\"TOKEN\" TEXT," + // 4: token
                "\"ZHUZHIYISHENG\" TEXT);"); // 5: zhuzhiyisheng
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DENG_LU_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DengLuBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String zhuji = entity.getZhuji();
        if (zhuji != null) {
            stmt.bindString(2, zhuji);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(3, username);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(5, token);
        }
 
        String zhuzhiyisheng = entity.getZhuzhiyisheng();
        if (zhuzhiyisheng != null) {
            stmt.bindString(6, zhuzhiyisheng);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DengLuBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String zhuji = entity.getZhuji();
        if (zhuji != null) {
            stmt.bindString(2, zhuji);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(3, username);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(5, token);
        }
 
        String zhuzhiyisheng = entity.getZhuzhiyisheng();
        if (zhuzhiyisheng != null) {
            stmt.bindString(6, zhuzhiyisheng);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public DengLuBean readEntity(Cursor cursor, int offset) {
        DengLuBean entity = new DengLuBean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // zhuji
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // username
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // password
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // token
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // zhuzhiyisheng
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DengLuBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setZhuji(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsername(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPassword(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setToken(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setZhuzhiyisheng(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DengLuBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DengLuBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DengLuBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
