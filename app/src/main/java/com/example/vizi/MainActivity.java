package com.example.vizi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected Intent visualizeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Objects in screen
        Button visualizeButton = findViewById(R.id.visualize_button);

        // Navigation Intents
        visualizeIntent = new Intent(this, CountryPage.class);

        visualizeButton.setOnClickListener((view) -> {
            startActivity(visualizeIntent);
        });

        //
    }
}