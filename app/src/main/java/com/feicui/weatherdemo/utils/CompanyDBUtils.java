package com.feicui.weatherdemo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.feicui.weatherdemo.entity.city.CityInfo;

import java.util.ArrayList;

/**
 * Created by yukai on 2016/8/4.
 */
public class CompanyDBUtils {
    private static CompanyDBUtils sInstance;

    private CompanyDBHelper helper;

    private SQLiteDatabase database;

    public CompanyDBUtils(Context context) {
        helper = new CompanyDBHelper(context);
        database = helper.getWritableDatabase();
    }

    /**
     * 单例设置
     * **/
    public static CompanyDBUtils getsInstance(Context context){

        if (sInstance == null){
            synchronized (CompanyDBUtils.class){
                if (sInstance == null) {
                    sInstance = new CompanyDBUtils(context);
                }
            }
        }
        return sInstance;
    }

    /**
     * 向城市表中插入数据
     * **/
    public void insertName(CityInfo info){
        ContentValues values = new ContentValues();
        values.put(CompanyDBHelper.CITY_NAME,info.getCity());
        database.insert(CompanyDBHelper.CITY_TABLE_NAME,null,values);
    }


    /*
    * 查询数据
    * */
    public ArrayList<CityInfo> getCompanyDatas(){
        ArrayList<CityInfo> newsList = new ArrayList<>();
        String str = " select * from " + CompanyDBHelper.CITY_TABLE_NAME;
        Cursor cursor = database.rawQuery(str,null);
        while (cursor.moveToNext()) {
            String city = cursor.getString(cursor.getColumnIndex(CompanyDBHelper.CITY_NAME));
            newsList.add(new CityInfo(city));
        }
        cursor.close();
        return newsList;
    }
}
