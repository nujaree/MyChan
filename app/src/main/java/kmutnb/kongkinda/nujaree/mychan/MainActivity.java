package kmutnb.kongkinda.nujaree.mychan;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //Explictit
    private ManageTABLE objManageTABLE;
    private EditText searchTitleEditText;
    private Spinner categorySpinner;
    private ListView titleListView;
    private String searchTitleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind Widget
        bindWidget();
        //Connected Database
        objManageTABLE = new ManageTABLE(this);


        //Tester Add Value
        //objManageTABLE.addValue("TestCat", "TestTitle", "นี่หัวข้อข่าว", "detail", "source", "Lat", "lng", "review");

        //Delete All Data
        deleteAllData();

        //Synchronize Data from xml
        synXMLtoSQLite();

    }   // Main Method

    private void bindWidget() {
        searchTitleEditText = (EditText) findViewById(R.id.editText);
        categorySpinner = (Spinner) findViewById(R.id.spinner);
        titleListView = (ListView) findViewById(R.id.listView);
    }

    public void clickSearch(View view) {

        searchTitleString = searchTitleEditText.getText().toString().trim();

        //Check Space
        if (searchTitleString.equals("")) {

            //Have Space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(MainActivity.this,"Have Space","กรุณากรอกช่องค้นหาด้วยค่ะ");
        } else {

            //No Space
            checkSearchTitle();

        }
    } //clickSearch

    private void checkSearchTitle() {

        try {

            String[] strRrsult = objManageTABLE.searchTitle(searchTitleString);
            Log.d("Chan"," Head ==>" + strRrsult[3]);

        } catch (Exception e) {
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(MainActivity.this,"ไม่มีสถานที่ท่องเที่ยวนี้","ไม่มีสถานที่ท่องเที่ยวนี้ในฐานข้อมูลของเรา ");
        }

    }  // checkSearchTitle

    public void clickListAll(View view) {

    }


    private void synXMLtoSQLite() {

        //Get Value For xml
        String[] strCategory = getResources().getStringArray(R.array.Category);
        String[] strTitle = getResources().getStringArray(R.array.Title);
        String[] strHead = getResources().getStringArray(R.array.Head);
        String[] strDetail = getResources().getStringArray(R.array.Detail);
        String[] strSource = getResources().getStringArray(R.array.Source);
        String[] strLat = getResources().getStringArray(R.array.Lat);
        String[] strLng = getResources().getStringArray(R.array.Lng);

        for (int i=0;i<strCategory.length;i++) {

            objManageTABLE.addValue(strCategory[i],
                    strTitle[i],
                    strHead[i],
                    strDetail[i],
                    strSource[i],
                    strLat[i],
                    strLng[i],
                    "Nothing");

        } //for


    }  //synXMLtoSQLite

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, MODE_PRIVATE, null);
        objSqLiteDatabase.delete(ManageTABLE.TABLE_CHAN, null, null);
    }
}   // Main Class
