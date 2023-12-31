package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password;
    Button register;
    MyDBHelper dbHelper = new MyDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if it's the first run
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (!isFirstRun) {
            Intent intent = new Intent(RegisterActivity.this, FlashCardActivity.class);
            startActivity(intent);
            finish();  // Finish the activity to prevent it from being opened again
        } else {
            setContentView(R.layout.activity_register);  // Set content view after checking isFirstRun

            email = findViewById(R.id.editEmail);
            password = findViewById(R.id.editPassword);
            register = findViewById(R.id.register);

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.addParent(email.getText().toString(), password.getText().toString());
                    Intent intent = new Intent(RegisterActivity.this, CreateChildProfileActivity.class);
                    startActivity(intent);

                    // Update isFirstRun to false after registration
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isFirstRun", false).apply();
                    finish();  // Finish the activity to prevent it from being opened again
                }
            });
        }
    }
}
