package com.example.cse226_2021;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class P4CustomAdapter extends ArrayAdapter<P4Item> {
    Context c;
    ArrayList<P4Item> items;

    public P4CustomAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<P4Item> objects) {
        super(context, textViewResourceId, objects);
        c=context;
        items=objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater=LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.p4listlayout,null);
        ImageView image=v.findViewById(R.id.image_id);
        image.setImageResource(items.get(position).image_resource_id);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(items.get(position).image_resource_id!=R.drawable.img_1)
                    items.get(position).image_resource_id=0;
                notifyDataSetChanged();
            }
        });
        TextView name=v.findViewById(R.id.name);
        name.setText(items.get(position).getName());
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!items.get(position).name.equals(""))
                    items.get(position).name="";
                notifyDataSetChanged();
            }
        });
        Button delete=v.findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);
                Toast.makeText(c, "Removed Item:"+position+1, Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
        return v;
    }
}
