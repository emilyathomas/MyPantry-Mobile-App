package com.example.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        Intent groceryIntent = new Intent(MainActivity.this, GroceryActivity.class);
        Intent addPantryIntent = new Intent(MainActivity.this, addPantry.class);

        ImageButton groceryBtn = findViewById(R.id.groceryBtn);
        groceryBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(groceryIntent);
            }
        });

        mFAB = findViewById(R.id.addItem);
        mFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(addPantryIntent);
            }
        });
    }
}