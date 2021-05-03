package com.example.vizi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class CountryPage extends AppCompatActivity {
    CardView storyOneCard, storyTwoCard, storyThreeCard, storyFourCard;
    Intent storyOneIntent, storyTwoIntent, storyThreeIntent, storyFourIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_page);

        // Instantiate Objects
        storyOneCard = findViewById(R.id.cardViewOne);
        storyTwoCard = findViewById(R.id.cardViewTwo);
        storyThreeCard = findViewById(R.id.cardViewThree);
        storyFourCard = findViewById(R.id.cardViewFour);

        // Navigation Intents
        storyOneIntent = new Intent(this, CaseDeathCount.class);
        storyTwoIntent = new Intent(this, GoogleMobility.class);
        storyThreeIntent = new Intent(this, ExportEstimation.class);
        storyFourIntent = new Intent(this, FDIEstimation.class);

        // Navigation On Click Listeners
        storyOneCard.setOnClickListener((view) -> {
            startActivity(storyOneIntent);
        });
        storyTwoCard.setOnClickListener((view) -> {
            startActivity(storyTwoIntent);
        });
        storyThreeCard.setOnClickListener((view) -> {
            startActivity(storyThreeIntent);
        });
        storyFourCard.setOnClickListener((view) -> {
            startActivity(storyFourIntent);
        });

    }
}