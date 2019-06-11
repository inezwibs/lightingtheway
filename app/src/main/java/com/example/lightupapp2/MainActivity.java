package com.example.lightupapp2;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class MainActivity extends AppCompatActivity
       {


    private static final String TAG = "Main Activity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate:Starting.");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }

    private void setupViewPager(ViewPager mViewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new com.example.lightupapp2.Tab1Fragment(),"Home");
        adapter.addFragment(new com.example.lightupapp2.Tab2Fragment(),"Find Contacts");
        adapter.addFragment(new com.example.lightupapp2.Tab3Fragment(),"Search");
        adapter.addFragment(new com.example.lightupapp2.Tab4Fragment(),"Take Action");

        mViewPager.setAdapter(adapter);

    }


}



