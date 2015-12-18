package kmutnb.kongkinda.nujaree.mychan;

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
        objManageTABLE.addValue("TestCat", "TestTitle", "นี่หัวข้อข่าว", "detail", "source", "Lat", "lng", "review");

    }   // Main Method
}   // Main Class
