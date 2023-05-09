package com.example.mypantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypantry.model.GroceryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroceryActivity extends AppCompatActivity {

    private FloatingActionButton mFAB;
    public GroceryAdapterListBasic mAdapter;
    public RecyclerView recyclerView;

    private List<GroceryItem> items = new ArrayList<>();


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String groceryName = data.getStringExtra("GroceryName");
            String groceryQuantity = data.getStringExtra("GroceryQuantity");
            String grocerySKU = data.getStringExtra("GrocerySKU");
            if (groceryName != null && groceryQuantity != null && grocerySKU != null) {
                items.add(new GroceryItem(groceryName, groceryQuantity, grocerySKU));
                mAdapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();
        String groceryName = intent.getStringExtra("GroceryName");
        String groceryQuantity = intent.getStringExtra("GroceryQuantity");
        String grocerySKU = intent.getStringExtra("GrocerySKU");
        if (groceryName != null && groceryQuantity != null && grocerySKU != null) {
            items.add(new GroceryItem(groceryName, groceryQuantity, grocerySKU));
        }

        mAdapter = new GroceryAdapterListBasic(this, items);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

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
                startActivityForResult(addGroceryIntent, 1);
            }
        });

    }
}