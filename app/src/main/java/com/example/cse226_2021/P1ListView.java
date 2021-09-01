package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P1ListView extends AppCompatActivity {
String countryList1[] = {"INDIA", "GERMANY", "SPAIN", "SWEDEN", "CUBAN"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_list_view);
       ArrayAdapter a1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countryList1);
        ListView l1= findViewById(R.id.L1);
        l1.setAdapter(a1);

    }
}
