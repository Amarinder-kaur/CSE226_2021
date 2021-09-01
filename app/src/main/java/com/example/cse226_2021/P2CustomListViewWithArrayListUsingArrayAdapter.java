package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class P2CustomListViewWithArrayListUsingArrayAdapter extends AppCompatActivity {
    ListView simpleList;
    ArrayList<P2Item> animalList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_custom_list_view_with_array_list_using_array_adapter);

        animalList.add(new P2Item("Lion",R.drawable.lion));
        animalList.add(new P2Item("Tiger",R.drawable.lion));
        animalList.add(new P2Item("Monkey",R.drawable.lion));
        animalList.add(new P2Item("Elephant",R.drawable.lion));


        P2CustomAdapter myAdapter=new P2CustomAdapter(this,R.layout.p2listlayout,animalList);

        simpleList =  findViewById(R.id.simpleListView);
        simpleList.setAdapter(myAdapter);
          }
}
