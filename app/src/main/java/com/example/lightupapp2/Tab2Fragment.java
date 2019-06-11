package com.example.lightupapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Tab2Fragment extends Fragment{
    String destinationLatitude = "37.7185412";
    String destinationLongitude = "-122.4829333";

    private static final String TAG= "Tab2Fragment";

    private Button makeReport, makeAnonReport, btnTEST2c, btnTest2d;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);

        makeReport = (Button) view.findViewById(R.id.makeReport);
        makeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Testing Button Click 2a", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), ResultsActivity.class);

                //intent.putExtra("someobject", list.get(position)) //passing object to the new activity.
                startActivity(intent);
            }

        });

        makeAnonReport = (Button) view.findViewById(R.id.makeAnonReport);
        makeAnonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Testing Button Click 2b", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ResultsActivity.class);
                startActivity(intent);

            }

        });

        btnTEST2c = (Button) view.findViewById(R.id.btnTEST2c);
        btnTEST2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Testing Button Click 2c", Toast.LENGTH_SHORT).show();
                //NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                //navController.navigate(R.id.action_tab2Fragment_to_tab3Fragment);

                Uri gmmNonProfitIntentUri =  Uri.parse("geo:"+destinationLatitude+","+destinationLongitude+"?q=nonprofit+near+sfsu");


                String uri = "http://maps.google.com/maps?saddr" + destinationLatitude + "," + destinationLongitude + " (" + "SFSU" + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmNonProfitIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);


            }

        });

        btnTest2d = (Button) view.findViewById(R.id.findCouseling);
        btnTest2d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Testing Button 1d tested ", Toast.LENGTH_SHORT).show();
                Uri gmmCounselingIntentUri =  Uri.parse("geo:"+destinationLatitude+","+destinationLongitude+"?q=counseling+near+sfsu");


                Intent cIntent = new Intent(Intent.ACTION_VIEW, gmmCounselingIntentUri);
                cIntent.setPackage("com.google.android.apps.maps");
                startActivity(cIntent);
            }
        });

        return view;

    }

}

