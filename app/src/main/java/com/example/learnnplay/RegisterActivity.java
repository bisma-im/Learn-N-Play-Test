package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.editEmail);
        password= findViewById(R.id.editPassword);
        register = findViewById(R.id.register);
        MyDBHelper dbHelper = new MyDBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addParent(email.getText().toString(), password.getText().toString());
                Intent intent = new Intent(RegisterActivity.this, CreateChildProfileActivity.class);
            }
        });
    }
}