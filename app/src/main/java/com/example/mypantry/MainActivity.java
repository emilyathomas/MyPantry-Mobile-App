package com.example.mypantry;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mypantry.model.PantryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFAB;
    public PantryAdapterListBasic mAdapter;
    public RecyclerView recyclerView;

    private List<PantryItem> items = new ArrayList<>();


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String pantryName = data.getStringExtra("pantryName");
            String pantryQuantity = data.getStringExtra("pantryQuantity");
            String pantrySKU = data.getStringExtra("pantrySKU");
            String pantryExpDate = data.getStringExtra("pantryExpDate");
            String pantryLocation = data.getStringExtra("pantryLocation");
            String pantryNote = data.getStringExtra("pantryNote");
            if (pantryName != null && pantryQuantity != null && pantrySKU != null && pantryExpDate != null && pantryLocation != null) {
                items.add(new PantryItem(pantryName, pantryQuantity, pantrySKU, pantryExpDate, pantryLocation, pantryNote));
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();
        String pantryName = intent.getStringExtra("GroceryName");
        String pantryQuantity = intent.getStringExtra("pantryQuantity");
        String pantrySKU = intent.getStringExtra("pantrySKU");
        String pantryExpDate = intent.getStringExtra("pantryExpDate");
        String pantryLocation = intent.getStringExtra("pantryLocation");
        String pantryNote = intent.getStringExtra("pantryNote");
        if (pantryName != null && pantryQuantity != null && pantrySKU != null) {
            items.add(new PantryItem(pantryName, pantryQuantity, pantrySKU, pantryExpDate, pantryLocation, pantryNote));
        }

        mAdapter = new PantryAdapterListBasic(this, items);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

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
                startActivityForResult(addPantryIntent, 1);
            }
        });
    }
}