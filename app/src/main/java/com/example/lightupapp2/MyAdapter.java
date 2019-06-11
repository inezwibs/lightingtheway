package com.example.lightupapp2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    //adapter of view holder type
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Model> list = new ArrayList<>();
    private Context mContext;
    private int selectedDataIndex;
    private OnRowListener mOnRowListener;

    public MyAdapter(ArrayList<Model> list, OnRowListener onRowListener, Context context) {
        this.list = list;
        this.mOnRowListener= onRowListener;
        this.mContext = context;

    }

    public MyAdapter(ArrayList<Model> list,Context context) {
        this.list = list;
        this.mContext = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG,"onCreateViewHolder: called.");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view, mOnRowListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        /*
        myViewHolder.cardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked.");
                Toast.makeText(mContext,, Toast.LENGTH_SHORT).show();

            }
        });
         */

        myViewHolder.name.setText(list.get(i).getName());
        myViewHolder.schoolname.setText(list.get(i).getSchoolname());
        myViewHolder.email.setText(list.get(i).getEmail());
        myViewHolder.title.setText(list.get(i).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //holding view to add to recycler

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, email, schoolname, title;
        LinearLayout linearLayout;
        OnRowListener mOnRowListener;

        public MyViewHolder(@NonNull View itemView, OnRowListener onRowListener) {
            super(itemView);
            Log.d(TAG,"MyViewHolder: called.");

            schoolname = (TextView) itemView.findViewById(R.id.schoolname);
            name = (TextView) itemView.findViewById(R.id.name);
            title = (TextView) itemView.findViewById(R.id.title);
            email = (TextView) itemView.findViewById(R.id.email);
            mOnRowListener = onRowListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG,"On Click of MyViewHolder: called.");
            mOnRowListener.onRowClick(getAdapterPosition());
        }
    }
    public interface OnRowListener{
        void onRowClick(int position);
    }
}

/*
public void setDetails(Context ctx, String name, String title, String schoolname, String email){
        //Views
        TextView txtViewSchoolName = (TextView) mView.findViewById(R.id.schoolname);
        TextView txtViewName = (TextView) mView.findViewById(R.id.name);
        TextView txtViewTitle = (TextView) mView.findViewById(R.id.title);
        TextView txtViewEmail = (TextView) mView.findViewById(R.id.email);
        //set data to views
        txtViewSchoolName.setText(schoolname);
        txtViewEmail.setText(email);
        txtViewName.setText(name);
        txtViewTitle.setText(title);
    }
 */
