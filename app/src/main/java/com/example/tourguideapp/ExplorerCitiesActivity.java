package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tourguideapp.Fragments.eventFragment;
import com.example.tourguideapp.Fragments.foodFragment;
import com.example.tourguideapp.Fragments.fragmentsPagerAdapter;
import com.example.tourguideapp.Fragments.hotelFragment;
import com.example.tourguideapp.Fragments.placeFragment;
import com.google.android.material.tabs.TabLayout;

public class ExplorerCitiesActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer_cities);

        viewPager = findViewById(R.id.view_pager);
        this.addPages();

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void addPages(){
        fragmentsPagerAdapter pagerAdapter = new fragmentsPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new foodFragment());
        pagerAdapter.addFragment(new hotelFragment());
        pagerAdapter.addFragment(new placeFragment());
        pagerAdapter.addFragment(new eventFragment());

        //SET ADAPTER TO VIEWPAGER
        viewPager.setAdapter(pagerAdapter);
    }
}