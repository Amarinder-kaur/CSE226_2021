package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class P15FloatingActionList extends AppCompatActivity {
    ListView listItemView;
    FloatingActionButton fab;

    String[] listItemsValue = new String[] {
            "Android",    "PHP",
            "Web Development",
            "Blogger",
            "SEO",
            "Photoshop",
            "Android Studio",
            "Eclipse",
            "SDK Manager",
            "AVD Manager"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p15_floating_action_list);
        listItemView = (ListView) findViewById(R.id.listView1);
        fab = (FloatingActionButton) findViewById(R.id.fab1);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(P15FloatingActionList.this,android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);

                listItemView.setAdapter(adapter);

                Toast.makeText(P15FloatingActionList.this,
                        "Fab Clicked", Toast.LENGTH_LONG).show();

            }

        });
    }
}

