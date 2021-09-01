package com.example.cse226_2021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadaptertry extends BaseAdapter {
    Context context;
    String countryList[];
    int flags[];
    LayoutInflater inflter;
    public customadaptertry(Context applicationContext, String[] countryList, int[] flags) {
        this.context = applicationContext;
        this.countryList = countryList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));// where we want to inflate the layout answer is ApplicationContext
    }
    @Override
    public int getCount() {
        return countryList.length;//returns the total count to adapter
    }
//    This function is used to Get the data item associated with the specified position in the data set to obtain the
//    corresponding data of the specific location in the collection of data items.
    @Override
    public Object getItem(int position) {
        return null;
     }
//    it returns the corresponding to the position item ID. The function returns a long value of item position to the adapter.
    @Override
    public long getItemId(int position) {
        return 0;
    }
   /*This function is automatically called when the list item view is ready to be
     displayed or about to be displayed. In this function we set the layout for list
     items using LayoutInflater class and then add the data to the views
     like ImageView, TextView etc.*/
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //inflate the layout for each list row
        view = inflter.inflate(R.layout.layoutdesign, null);
        // get the TextView for country text and item flag
        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        //sets the text for country text and item flag from the current item object
        country.setText(countryList[position]);
        icon.setImageResource(flags[position]);

        // returns the view for the current row
        return view;
    }
}
