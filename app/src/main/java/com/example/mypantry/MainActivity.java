package com.example.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        Intent intent = new Intent(MainActivity.this, GroceryActivity.class);

        ImageButton groceryBtn = findViewById(R.id.groceryBtn);
        groceryBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}