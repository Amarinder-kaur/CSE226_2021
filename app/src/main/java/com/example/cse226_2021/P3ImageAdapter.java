package com.example.cse226_2021;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

class P3ImageAdapter extends ArrayAdapter<P3Item> {
    private final Context context;
    ArrayList<P3Item> arrayList = new ArrayList<P3Item>();
    public P3ImageAdapter(Context context, int textViewResourceId, ArrayList<P3Item> objects) {
        super(context, textViewResourceId , objects);
        this.context = context;
        arrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.p3griditemlayout , null);
        TextView textView = v.findViewById(R.id.textView1);
      final ImageView imageView = v.findViewById(R.id.imageView1);
        textView.setText(arrayList.get(position).getPlaceName());
        imageView.setImageResource(arrayList.get(position).getPlaceImage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int position = (Integer) v.getTag();
  //              String s = Integer.toString(position);
                Intent intent = new Intent(context, P3ImageDisplayNextActivity.class);
                intent.putExtra("IMAGE_ID", arrayList.get(position).getPlaceImage());
                context.startActivity(intent);
            }
        });
        final Button btn = v.findViewById(R.id.btn1);

        btn.setTag(position);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                String s = Integer.toString(position);
                Log.i("position" , s);
                Toast.makeText(context, "position of item deleted"+position, Toast.LENGTH_SHORT).show();
                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });

        return v;
    }
}