package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class P3CustomGridViewImages extends AppCompatActivity {
    ArrayList<P3Item> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_custom_grid_view_images);
        animalList.add(new P3Item("TajMehal", R.drawable.img));
        animalList.add(new P3Item("Budha Statue", R.drawable.img_10));
        animalList.add(new P3Item("South Indian Temple", R.drawable.img_11));
        animalList.add(new P3Item("Mountains", R.drawable.img_2));
        animalList.add(new P3Item("Red Fort", R.drawable.img_4));
        animalList.add(new P3Item("Golden Temple", R.drawable.img_5));

        P3ImageAdapter myAdpter = new P3ImageAdapter (getApplicationContext(), R.layout.p3griditemlayout, animalList);
        GridView simpleList = findViewById(R.id.mylist);
        simpleList.setAdapter(myAdpter);
    }
}