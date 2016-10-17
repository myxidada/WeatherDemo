package com.feicui.weatherdemo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yukai on 2016/8/4.
 */
public class CompanyDBHelper extends SQLiteOpenHelper{

    private final static String INFO_DB = "data";//数据库名

    public final static String CITY_TABLE_NAME = "city";//用户表名

    public final static String CITY_NAME = "city_name";//城市名字

    public CompanyDBHelper(Context context){
        super(context, INFO_DB , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建用户信息表
        db.execSQL("create table " + CITY_TABLE_NAME + " ( " +
                CITY_NAME + " varchar(255), " +
                      " );");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
//                CITY_ID + " varchar(255), " +
//                ABSTRACT + " varchar(255) " + " );");
//                PROVINCE + " varchar(255), " +