package com.example.mypantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GroceryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_main);

        Intent intent = new Intent(GroceryActivity.this, MainActivity.class);

        ImageButton homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}