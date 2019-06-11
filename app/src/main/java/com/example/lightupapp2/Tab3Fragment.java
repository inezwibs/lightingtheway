package com.example.lightupapp2;
import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class Tab3Fragment extends Fragment implements MyAdapter.OnRowListener{

    private static final String TAG = "Tab3Fragment";

    private ArrayList<Model> list = new ArrayList<>();
    //get ref to recycler view in tab3 fragment
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private MyAdapter myAdapter;
    private DocumentSnapshot mLastQuery;


    View view;


 @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started. ");

        view = inflater.inflate(R.layout.tab3_fragment, container, false);
        //Firebase query
        initViews();
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myAdapter = new MyAdapter(list, this, getActivity());
        mRecyclerView.setAdapter(myAdapter);


        return view;

    }




    private void initViews() {
        //get reference to recyclerview
        /*
        if(myAdapter == null){
            myAdapter = new MyAdapter(list,getActivity());
        }
         */
        ref = FirebaseDatabase.getInstance().getReference().child("lightupapp-43243");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        Log.d(TAG, "initRecyclerView: created.");

        //get ref to search view
        mSearchView = (SearchView) view.findViewById(R.id.searchView);
        Log.d(TAG, "initSearchView: created.");


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: started. ");

        super.onViewCreated(view, savedInstanceState);
        list.add(new Model("Luoluo Hong","San Francisco State University","VP of Student Affairs, Title IX Coordinator","vpsaem@sfsu.edu"));
        list.add(new Model("Leilani F. Battiste, S.J.D.","City College of San Francisco ","Deputy General Counsel, Title IX Coord","lbattiste@ccsf.edu"));
        list.add(new Model("Max Hartman", "Canada College", "Dean of Counseling, Title IX Coordinator", "hartmanmax@smccd.edu"));
        list.add(new Model("Dr. Angelica Garcia", "Skyline College", "VP of Student Services, Title IX Coordinator", "garciaa@smccd.edu"));
        list.add(new Model("Lizette Bricker", "College of San Mateo", "Dean Enrollment Services, Title IX Coordinator", "bricker@smccd.edu"));
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        list.add(ds.getValue(Model.class));
                    }
                    myAdapter = new MyAdapter(list, getActivity());
                    mRecyclerView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                    if(list.isEmpty()){
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }else{
                        mRecyclerView.setVisibility(View.GONE);

                    }
                    //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        if (mSearchView != null) {
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }

    }
    private void search(String s) {
        ArrayList<Model> mylist = new ArrayList<>();
        for (Model obj : list) {
            if (obj.getSchoolname().toLowerCase().contains(s.toLowerCase())) {
                mylist.add(obj);
            }
        }
        MyAdapter myAdapter = new MyAdapter(mylist, this, getActivity());
        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onRowClick(int position) {
        Log.d(TAG,"onRowClick:clicked.");
        Intent intent;
        list.get(position);
        intent = new Intent(getActivity(), ResultsActivity.class);

        intent.putExtra("selected_row", list.get(position));//passing object to the new activity.
        startActivity(intent);
    }
}
