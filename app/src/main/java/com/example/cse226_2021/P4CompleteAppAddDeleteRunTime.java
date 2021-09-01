package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class P4CompleteAppAddDeleteRunTime extends AppCompatActivity {
    ListView lv;
    EditText e;
    ArrayList<P4Item> os_details;
    P4CustomAdapter adapter;
    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_complete_app_add_delete_run_time);
        os_details= new ArrayList<>();


        adapter=new P4CustomAdapter(this,R.layout.p4listlayout,os_details);
        lv=findViewById(R.id.custom_lv);
        e=findViewById(R.id.input);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on "+ ++position +" item", Toast.LENGTH_SHORT).show();
            }
        });
        imageView = (ImageView)findViewById(R.id.imageViewDisplay);
        button = (Button)findViewById(R.id.buttonLoadPicture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
    public void addData(View v){
        os_details.add(new P4Item(e.getText().toString(),R.drawable.img));
        adapter.notifyDataSetChanged();
        e.setText("");
    }
}
