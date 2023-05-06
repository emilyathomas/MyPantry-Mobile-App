package com.example.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class mealRecommendation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_recommendations);

        Intent intent = new Intent(mealRecommendation.this, MainActivity.class);

        Button groceryBtn = findViewById(R.id.close_recipe);
        groceryBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
