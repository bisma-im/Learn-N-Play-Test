package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class QuizProgressActivity extends AppCompatActivity {
    TextView scoreTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_progress);
        scoreTextView = findViewById(R.id.score);

        MyDBHelper dbHelper = new MyDBHelper(this);
        String childName = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("childName",null);

        if (childName != null) {
            int score = dbHelper.getScore(childName);
            scoreTextView.setText(String.valueOf(score));
        } else {
            Log.e("QuizProgressActivity", "Child name is null");
        }
    }
}


