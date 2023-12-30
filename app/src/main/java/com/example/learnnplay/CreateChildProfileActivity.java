package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateChildProfileActivity extends AppCompatActivity {

    EditText name, age;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child_profile);

        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        MyDBHelper dbHelper = new MyDBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addChild(name.getText().toString(), Integer.parseInt(age.getText().toString()));
                Intent intent = new Intent(CreateChildProfileActivity.this, FlashCardActivity.class);
                startActivity(intent);
            }
        });
    }
}