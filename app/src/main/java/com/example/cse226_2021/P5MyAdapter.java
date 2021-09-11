package com.example.cse226_2021;
//https://developer.android.com/guide/topics/ui/layout/recyclerview?gclid=CjwKCAjwybyJBhBwEiwAvz4G7-7o6diLUZG7c9_lJ7s39kAVWsf-BJmSvyvCGu0dypn2KKihEnR_xhoCD4YQAvD_BwE&gclsrc=aw.ds
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class P5MyAdapter extends RecyclerView.Adapter<P5MyAdapter.MyViewHolder> {
    Context ct;
    ArrayList<P5Person> al;

    P5MyAdapter(Context ct, ArrayList<P5Person> al) {
        this.ct = ct;
        this.al = al;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(ct);

        View v1 = li.inflate(R.layout.p5my_layout, parent, false);

        return new MyViewHolder(v1);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        P5Person p = al.get(position);
        holder.tvName.setText(p.getName());
        holder.tvReg.setText(p.getReg());
        holder.iv.setImageResource(p.getImage());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvReg;
        ImageView iv, ivremove;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvname);
            tvReg = (TextView) itemView.findViewById(R.id.tvreg);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            ivremove = (ImageView) itemView.findViewById(R.id.ivremove);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll);

            ivremove.setVisibility(View.INVISIBLE);

            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ivremove.setVisibility(View.VISIBLE);
                    ivremove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            delete(getAdapterPosition());
                            ivremove.setVisibility(View.INVISIBLE);
                        }
                    });
                    return true;
                }
            });
        }
            public void delete(int position)
            {
                Toast.makeText(ct,"deleting posion is "+position,Toast.LENGTH_SHORT).show();
                al.remove(position);
                notifyDataSetChanged();
        }
    }
}