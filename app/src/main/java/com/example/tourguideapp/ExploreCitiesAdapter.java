package com.example.tourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExploreCitiesAdapter extends ArrayAdapter<ExploreCities> {

    public ExploreCitiesAdapter (Activity context, ArrayList<ExploreCities> exploreCities) {
        super(context, 0, exploreCities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.design_list, parent, false);
        }

        ExploreCities currentMusicList = getItem(position);

        TextView nameTextView =  listItemView.findViewById(R.id.info_textView);
        nameTextView.setText(currentMusicList.getInfoText());

        ImageView imageView =  listItemView.findViewById(R.id.place_imageView);
        Picasso.get().load(currentMusicList.getImageResourceId()).into(imageView);

        return listItemView;
    }
}
