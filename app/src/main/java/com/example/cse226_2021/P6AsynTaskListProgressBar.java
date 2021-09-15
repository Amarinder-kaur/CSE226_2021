package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class P6AsynTaskListProgressBar extends AppCompatActivity {
    ProgressBar pb;
    ListView lv;
   String [] ar = {"1","2","3","4","5","6","7","8","9","10"};
    ArrayList<String> al;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_asyn_task_list_progress_bar);
        pb =(ProgressBar) findViewById(R.id.pb);
        lv =(ListView) findViewById(R.id.lv);

        al = new ArrayList<>();
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ad);
        new MyTask().execute();
    }
//1st parameter: The type of the input variables value you want to set to the background process. This can be an array of objects.
//
//2nd parameter – The type of the objects you are going to enter in the onProgressUpdate method.
//
//3rd parameter – The type of the result from the operations you have done in the background process.
    class MyTask extends AsyncTask<Void,Integer,String>
    {
        int count;
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            pb.setMax(10);
            pb.setProgress(0);
            pb.setVisibility(View.VISIBLE);
            count =0;
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i =1; i<=10; i++)
            {
                count = count+1;
               publishProgress(i);
                try {
                    Thread.sleep(1000);
                    al.add(ar[count-1]);
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return  "Completed";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            // super.onProgressUpdate(values);
            pb.setProgress(values[0]);
            //al.add(ar[count-1]);
            //ad.notifyDataSetChanged();

        }

        @Override
        protected void onPostExecute(String s) {
            // super.onPostExecute(s);
            Toast.makeText(P6AsynTaskListProgressBar.this, s, Toast.LENGTH_SHORT).show();
            ad.notifyDataSetChanged();
            pb.setVisibility(View.INVISIBLE);
        }
    }

}
//change style="@style/Widget.AppCompat.ProgressBar.Horizontal" in xml
//or @style/Widget.AppCompat.ProgressBar