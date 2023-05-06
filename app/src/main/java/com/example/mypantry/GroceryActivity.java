package com.example.mypantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GroceryActivity extends AppCompatActivity {

    private FloatingActionButton mFAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_main);

        Intent mainIntent = new Intent(GroceryActivity.this, MainActivity.class);
        Intent addGroceryIntent = new Intent(GroceryActivity.this, addGrocery.class);
        ImageButton homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(mainIntent);
            }
        });

        mFAB = findViewById(R.id.addGroceryItem);
        mFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(addGroceryIntent);
            }
        });

    }
}