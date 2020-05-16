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

public class hotelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotel,container,false);
        ListView hotelListView = rootView.findViewById(R.id.hotel_listView);

        //Importing Arrays from resources file
        Resources res = getResources();
        final String[] hotelName = res.getStringArray(R.array.hotelName);
        final String[] hotelImage = res.getStringArray(R.array.hotelImage);
        final String[] hotelDescription = res.getStringArray(R.array.hotelDescription);

        ArrayList<ExploreCities> exploreCity = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            exploreCity.add(new ExploreCities(hotelName[i], hotelImage[i]));
        }

        ExploreCitiesAdapter listAdapter = new ExploreCitiesAdapter(this.getActivity(),exploreCity);
        hotelListView.setAdapter(listAdapter);

        //Implementing OnClickListener to ListView items
        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DisplayDetailActivity.class);
                /*
                 * Sending data to Display Details Activity
                 */
                intent.putExtra("NAME",hotelName[position]);
                intent.putExtra("IMAGE",hotelImage[position]);
                intent.putExtra("DESCRIPTION",hotelDescription[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
    @NonNull
    @Override
    public String toString() {
        return "Hotel";
    }
}
