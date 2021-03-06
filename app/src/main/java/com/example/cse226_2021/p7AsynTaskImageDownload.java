package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
// add interenet permission in manifest
public class p7AsynTaskImageDownload extends AppCompatActivity {
    URL ImageUrl = null;
    InputStream is = null;
    Bitmap bmImg = null;
    ImageView imageView= null;
    ProgressDialog p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_asyn_task_image_download);
        Button button= findViewById(R.id.asyncTask);
        imageView=findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskExample asyncTask=new AsyncTaskExample();
                asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
            }
        });
    }
    private class AsyncTaskExample extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(p7AsynTaskImageDownload.this);
            p.setMessage("Please wait...It is downloading");
            p.setCancelable(false);
            p.show();
        }

     /*
     getInputStream():  used t read data from a source
     HTTPURLConnection: URLConnection is an abstract class. The two subclasses HttpURLConnection and JarURLConnection
     makes the connetion between the client Java program and URL resource on the internet. With the help of URLConnection
     class, a user can read and write to and from any resource referenced by an URL object.

     Here are the steps for anyone browsing:
        Calculate the maximum possible inSampleSize that still yields an image larger than your target.
        Load the image using BitmapFactory. decodeFile(file, options) , passing inSampleSize as an option.
        Resize to the desired dimensions using Bitmap. createScaledBitmap()
        BitmapFactory.options :Creates Bitmap objects from various sources, including files, streams, and byte-arrays.*/

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                ImageUrl = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) ImageUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                is = conn.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bmImg = BitmapFactory.decodeStream(is, null, options);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmImg;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(imageView !=null) {
                p.hide();
                imageView.setImageBitmap(bitmap);
            }else {
                p.show();
            }
        }
    }
}