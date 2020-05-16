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

public class placeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place,container,false);
        final ListView placeListView = rootView.findViewById(R.id.place_listView);

        //Importing Arrays from resources file
        Resources res = getResources();
        final String[] placeName = res.getStringArray(R.array.placeName);
        final String[] placeImage = res.getStringArray(R.array.placeImage);
        final String[] placeDescription = res.getStringArray(R.array.placeDescription);


        ArrayList<ExploreCities> exploreCity = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            exploreCity.add(new ExploreCities(placeName[i], placeImage[i]));
        }

        ExploreCitiesAdapter listAdapter = new ExploreCitiesAdapter(this.getActivity(),exploreCity);
        placeListView.setAdapter(listAdapter);

        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DisplayDetailActivity.class);
                /*
                 * Sending data to Display Details Activity
                 */
                intent.putExtra("NAME",placeName[position]);
                intent.putExtra("IMAGE",placeImage[position]);
                intent.putExtra("DESCRIPTION",placeDescription[position]);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @NonNull
    @Override
    public String toString() {
        return "Place";
    }
}
