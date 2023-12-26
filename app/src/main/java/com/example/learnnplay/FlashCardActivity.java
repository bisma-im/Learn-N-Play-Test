package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FlashCardActivity extends AppCompatActivity {

    private static final int[] imageResourcesA = {
            R.drawable.ant,     // For "A for Ant"
            R.drawable.apple,   // For "A for Apple"
            // Add other images for letter A if they exist
    };

    // Array of audio resources for letter A
    private static final int[] audioResourcesA = {
            R.raw.a_for_ant,    // For "A for Ant"
            R.raw.a_for_apple,  // For "A for Apple"
            // Add other audios for letter A if they exist
    };

    // Array of image resources for letter B
    private static final int[] imageResourcesB = {
            R.drawable.ball,     // For "B for Ball"
            R.drawable.banana,   // For "B for Banana"
            // Add other images for letter B if they exist
    };

    // Array of audio resources for letter B
    private static final int[] audioResourcesB = {
            R.raw.b_for_ball,    // For "B for Ball"
            R.raw.b_for_banana,  // For "B for Banana"
            // Add other audios for letter B if they exist
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);


    }
}