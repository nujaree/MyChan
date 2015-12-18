package kmutnb.kongkinda.nujaree.mychan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 16/11/2558.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_CHAN = "chanTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_HEAD = "Head";
    public static final String COLUMN_DETAIL = "Detail";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";
    public static final String COLUMN_REVIEW = "Review";

    public ManageTABLE(Context context) {


        //Create & Connect Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Contructor

    //Search Title
    public String[] searchTitle(String strTitle) {


        try {

            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_CHAN,
                    new String[]{COLUMN_ID, COLUMN_CATEGORY, COLUMN_TITLE, COLUMN_HEAD, COLUMN_DETAIL, COLUMN_SOURCE, COLUMN_LAT, COLUMN_LNG, COLUMN_REVIEW},
                    COLUMN_TITLE + "=?",
                    new String[]{String.valueOf(strTitle)},
                    null,null,null,null);
            if (objCursor != null) {
                if (objCursor.moveToFirst()) {

                    strResult = new String[objCursor.getColumnCount()];
                    for (int i=0;i<objCursor.getColumnCount();i++) {

                        strResult[i] = objCursor.getString(i);
                    }
                } // if2
            } // if1
            objCursor.close();
            return strResult;


        } catch (Exception e) {
            return null;
        }
        //return new String[0];
    }

    //Add New Value to SQLite
    public long addValue(String strCategory,String strTitle,String strHead,String strDetail,String strSource,String strLat,String strLng,String strReview) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CATEGORY,strCategory);
        objContentValues.put(COLUMN_TITLE,strTitle);
        objContentValues.put(COLUMN_HEAD,strHead);
        objContentValues.put(COLUMN_DETAIL,strDetail);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_LAT,strLat);
        objContentValues.put(COLUMN_LNG,strLng);
        objContentValues.put(COLUMN_REVIEW,strReview);

        return writeSqLiteDatabase.insert(TABLE_CHAN,null,objContentValues);
    }
}   // /Main Class
