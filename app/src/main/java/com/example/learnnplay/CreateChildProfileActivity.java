package com.example.learnnplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CreateChildProfileActivity extends AppCompatActivity {

    List<ChildUser> childUsers = new ArrayList<>();
    EditText name, age;
    Button register;
    public static String currentChildName;
    MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child_profile);

        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        register = findViewById(R.id.register);
        dbHelper = new MyDBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentChildName = name.getText().toString();
                int childAge;
                childAge = Integer.parseInt(age.getText().toString());
                ChildUser childUser = new ChildUser(currentChildName, childAge, 0);
                childUsers.add(childUser);
                dbHelper.addChild(currentChildName, childAge);
                Intent intent = new Intent(CreateChildProfileActivity.this, QuizActivity.class);
                intent.putExtra("ChildName", currentChildName);
                startActivity(intent);
            }
        });
    }
}
