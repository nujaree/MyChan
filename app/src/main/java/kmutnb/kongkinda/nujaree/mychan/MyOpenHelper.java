package kmutnb.kongkinda.nujaree.mychan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 16/11/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String DATABASE_NAME = "chan.db" ;
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_CHAN = "create table chanTABLE (_id integer primary key, Category text,Title text,Head text,Detail text,Source text, Lat text,Lng text,Review text);";



    public MyOpenHelper(Context context) {
        super(context,DATABASE_NAME, null ,DATABASE_VERSION);
    }   //Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CHAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
