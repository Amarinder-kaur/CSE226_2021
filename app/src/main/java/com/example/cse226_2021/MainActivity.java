package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;

    String countryList[] = {"INDIA", "GERMANY", "SPAIN", "SWEDEN", "CUBAN"};
    int flags[] = {R.drawable.search, R.drawable.sound, R.drawable.search,
            R.drawable.sound, R.drawable.search};
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            // instantiate the custom list adapter
            customadaptertry customAdapter = new customadaptertry
                    (getApplicationContext(), countryList, flags);

        // get the ListView and attach the adapter
        simpleList = findViewById(R.id.simpleListView);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(getApplicationContext(),"you clicked on "+(position+1)+" item from the list",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
