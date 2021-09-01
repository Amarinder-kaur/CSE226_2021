package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class P3ImageDisplayNextActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_image_display_next);
        imageView = findViewById(R.id.fullImageView);
        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
        Integer imageId = getIntent().getIntExtra("IMAGE_ID",0);
        imageView.setImageResource(imageId);
    }
}