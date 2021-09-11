package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class P5RecyclerViewExample extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<P5Person> al;
    P5MyAdapter md;
    //LinearLayoutManager lm;
    EditText etName,etReg;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_recycler_view_example);
        etName =(EditText) findViewById(R.id.etname);
        etReg =(EditText) findViewById(R.id.etreg);

        rv = (RecyclerView) findViewById(R.id.rv);
        al = new ArrayList<>();
        md = new P5MyAdapter(this,al);

      // rv.setLayoutManager(lm);
       rv.setAdapter(md);
        //All LAyoutMAnager values
        //Use this LayoutManager when you want to show item in a vertical or horizontal scrolling list.

        //For LinearLayout=Horizontal(Default)
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
         rv.setLayoutManager(linearLayoutManager);

        // For LinearLayout=Horizontal
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //rv.setLayoutManager(linearLayoutManager);

        //You can show Grid view which scrolls either vertically or horizontally.
        // For GridLayout=vertical
     /*   int spanCount = 2;
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
       rv.setLayoutManager(gridLayoutManager);
*/

        //For GridLayout=vertical
     /*   int spanCount = 2;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(gridLayoutManager);
*/

        //For StaggeredGridLayout:  fit according to the size of images.
       /* int spanCount = 3;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
*/
    /*    int spanCount = 3;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
*/

    }

    public void dothis(View view)
    {
        String name = etName.getText().toString();
        int reg = Integer.parseInt(etReg.getText().toString());
        int image = R.drawable.search;
        P5Person p = new P5Person(name,reg,image);
        al.add(p);
        etName.setText("");
        etReg.setText("");
        md.notifyDataSetChanged();

    }
}
