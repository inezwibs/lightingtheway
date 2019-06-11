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
import androidx.navigation.fragment.NavHostFragment;

public class Tab1Fragment extends Fragment {



    private static final String TAG= "Tab1Fragment";
    String destinationLatitude = "37.7218762";
    String destinationLongitude = "-122.5484221";
    private Button btnTEST1a, findNonProfits, findTitleIX, findCouseling;

    private View.OnClickListener awesomeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            awesomeButtonClicked(v);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        btnTEST1a = (Button) view.findViewById(R.id.btnTEST1a);

        btnTEST1a.setOnClickListener(awesomeOnClickListener);


        findNonProfits = (Button) view.findViewById(R.id.findNonProfits);

        findNonProfits.setOnClickListener(awesomeOnClickListener);

        findTitleIX = (Button) view.findViewById(R.id.findTitleIX);

        findTitleIX.setOnClickListener(awesomeOnClickListener);

        findCouseling = (Button) view.findViewById(R.id.findCouseling);

        findCouseling.setOnClickListener(awesomeOnClickListener);


        return view;
    }

    private void awesomeButtonClicked(View v) {
        switch (v.getId()){
                case R.id.btnTEST1a:
                Toast.makeText(getActivity(), "Testing Button 1a tested",Toast.LENGTH_SHORT).show();
                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                    navController.navigate(R.id.action_tab1Fragment_to_tab2Fragment);
                    //NavHostFragment.findNavController(this).navigate(R.id.action_tab1Fragment_to_tab2Fragment);

                    break;

                case R.id.findNonProfits:
                Toast.makeText(getActivity(), "Testing Button 1b tested ", Toast.LENGTH_SHORT).show();
                Uri gmmNonProfitIntentUri =  Uri.parse("geo:"+destinationLatitude+","+destinationLongitude+"?q=nonprofit+near+sfsu");


                    String uri = "http://maps.google.com/maps?saddr" + destinationLatitude + "," + destinationLongitude + " (" + "SFSU" + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmNonProfitIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;

                case R.id.findTitleIX:
                Toast.makeText(getActivity(), "Testing Button 1c tested",Toast.LENGTH_SHORT).show();
                //replaceFragment(this);
                break;

                case R.id.findCouseling:
                Toast.makeText(getActivity(), "Testing Button 1d tested ", Toast.LENGTH_SHORT).show();
                Uri gmmCounselingIntentUri =  Uri.parse("geo:"+destinationLatitude+","+destinationLongitude+"?q=counseling+near+sfsu");


                Intent cIntent = new Intent(Intent.ACTION_VIEW, gmmCounselingIntentUri);
                cIntent.setPackage("com.google.android.apps.maps");
                startActivity(cIntent);
                break;

            default:
                break;

        }
    }
/*
public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id., someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

 */



}
