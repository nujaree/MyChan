package kmutnb.kongkinda.nujaree.mychan;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explictit
    private ManageTABLE objManageTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Connected Database
        objManageTABLE = new ManageTABLE(this);


        //Tester Add Value
        //objManageTABLE.addValue("TestCat", "TestTitle", "นี่หัวข้อข่าว", "detail", "source", "Lat", "lng", "review");

        //Delete All Data
        deleteAllData();

    }   // Main Method

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,MODE_PRIVATE,null);
        objSqLiteDatabase.delete(ManageTABLE.TABLE_CHAN,null,null);
    }
}   // Main Class
