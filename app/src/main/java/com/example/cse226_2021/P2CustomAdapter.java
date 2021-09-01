package com.example.cse226_2021;

import static android.R.color.holo_orange_dark;
import static com.example.cse226_2021.R.color.purple_200;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class P2CustomAdapter  extends ArrayAdapter<P2Item>
{        Context context;
    ArrayList<P2Item> animalList = new ArrayList<>();
public P2CustomAdapter(Context context, int textViewResourceId, ArrayList<P2Item> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        animalList = objects;
        }
@Override
public int getCount() {
        return super.getCount();
        }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.p2listlayout, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

        textView.setText(animalList.get(position).getAnimalName());
        imageView.setImageResource(animalList.get(position).getAnimalImage());
// Lookup view for data population
final Button btButton = (Button) v.findViewById(R.id.b1);
        // Cache row position inside the button using `setTag`(basically stores the object which requires to cast when you want to getTag)
        //btButton.setTag(position);
        btButton.setTag(position);
        // Attach the click event handler
        btButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        int position = (Integer) view.getTag();
        // Access the row position here to get the correct data item
        // P3Item user = getItem(position);
        String s=Integer.toString(position);
        Log.i("postionnnn",s);
        Toast.makeText(context,"position of item deleted"+position,Toast.LENGTH_SHORT).show();
        // Do what you want here...
        animalList.remove(position);
                //.get(position).animalImage;
        //reloading the list
        notifyDataSetChanged();
        }
        });
        // remove the particular textview when i click over there
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if (!animalList.get(position).animalName.equals(""))
                                animalList.get(position).animalName = "";
                        notifyDataSetChanged();
                }
                });
        // ... other view population as needed...
        // Return the completed view
        return v;

}

        }


