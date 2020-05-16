package com.example.tourguideapp.Fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tourguideapp.DisplayDetailActivity;
import com.example.tourguideapp.ExploreCities;
import com.example.tourguideapp.ExploreCitiesAdapter;
import com.example.tourguideapp.R;

import java.util.ArrayList;

public class eventFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event,container,false);
        ListView eventListView = rootView.findViewById(R.id.event_listView);

        //Importing Arrays from resources file
        Resources res = getResources();
        final String[] eventName = res.getStringArray(R.array.eventName);
        final String[] eventImage = res.getStringArray(R.array.eventImage);
        final String[] eventDescription = res.getStringArray(R.array.eventDescription);

        /*
        * Adding Data to ListVIew
        */
        ArrayList<ExploreCities> exploreCity = new ArrayList<>();

        for (int i  = 0; i < 8; i++){
            exploreCity.add(new ExploreCities(eventName[i], eventImage[i]));
        }

        ExploreCitiesAdapter listAdapter = new ExploreCitiesAdapter(this.getActivity(),exploreCity);
        eventListView.setAdapter(listAdapter);

        //Implementing OnClickListener to ListView items
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DisplayDetailActivity.class);
                /*
                * Sending data to Display Details Activity
                */
                intent.putExtra("NAME",eventName[position]);
                intent.putExtra("IMAGE",eventImage[position]);
                intent.putExtra("DESCRIPTION",eventDescription[position]);
                startActivity(intent);
            }
        });
        return rootView;
    }

    // Returns Name of Tab
    @NonNull
    @Override
    public String toString() {
        return "Events";
    }
}