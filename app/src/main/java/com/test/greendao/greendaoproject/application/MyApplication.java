package com.test.greendao.greendaoproject.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.test.greendao.greendaoproject.dao.DaoMaster;
import com.test.greendao.greendaoproject.dao.DaoSession;
import com.test.greendao.greendaoproject.utils.LogUtils;
import com.test.greendao.greendaoproject.utils.SDCardUtils;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;


/**
 * Created by zhouwei on 2018/5/7.
 */

public class MyApplication extends Application {
    private boolean isTest = true;
    //非加密的DaoSession
    private static DaoSession daoSession;
    private static DaoSession enctryptDaoSession;

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        LogUtils.printResult("SD:" + SDCardUtils.INNERSDPATH);

        QueryBuilder.LOG_SQL = true;

        QueryBuilder.LOG_VALUES = true;

        //非加密的数据库
        SQLiteDatabase database = new DaoMaster.DevOpenHelper(this, SDCardUtils.INNERSDPATH + "/stu.db").getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

//        //加密的数据库
//        Database encryptDb = new DaoMaster.DevOpenHelper(this,SDCardUtils.INNERSDPATH + "/teacher.db3").getEncryptedWritableDb("123456");
//        enctryptDaoSession = new DaoMaster(encryptDb).newSession();
    }

    /**
     * 公开获取当前数据库对应的唯一DaoSession，后期访问此数据库表的Dao
     * 可以通过此DaoSession来获取相应的XXXDao实例，做对表的CRUD操作
     * @return
     */
    public static DaoSession getDaoSession(){
        return daoSession;
    }

    /**
     * 加密的DaoSession
     * @return
     */
    public static DaoSession getEncryptDaoSession(){
        return daoSession;
    }
}
