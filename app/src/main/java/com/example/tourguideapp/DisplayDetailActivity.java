package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail);

        ImageView imageView = findViewById(R.id.display_imageView);
        TextView nameTextView = findViewById(R.id.display_nameTV);
        TextView descriptionTextView = findViewById(R.id.display_descriptionTV);
        Button backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String imageURL = intent.getStringExtra("IMAGE");
        String description = intent.getStringExtra("DESCRIPTION");

        nameTextView.setText(name);
        Picasso.get().load(imageURL).into(imageView);
        descriptionTextView.setText(description);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayDetailActivity.this,ExplorerCitiesActivity.class);
                startActivity(i);
            }
        });
    }
}
