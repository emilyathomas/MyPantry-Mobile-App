package com.example.mypantry;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addPantry extends AppCompatActivity {
    private FloatingActionButton mFAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pantry_item);

        Intent pantryIntent = new Intent(addPantry.this, MainActivity.class);

        Button closeAdd = findViewById(R.id.close_addPantry);
        closeAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(pantryIntent);
            }
        });

        Button addItem = findViewById(R.id.addPantryItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText itemName = (EditText) findViewById(R.id.itemName);
                String newName = itemName.getText().toString();
                pantryIntent.putExtra("Name", newName);

                TextView itemQuantity = (TextView) findViewById(R.id.itemQuantity);
                String newQuantity = itemQuantity.getText().toString();
                pantryIntent.putExtra("Quantity", newQuantity);

                EditText itemExpDate = (EditText) findViewById(R.id.itemExpDate);
                String newExpDate = itemExpDate.getText().toString();
                pantryIntent.putExtra("Exp Date", newExpDate);

                RadioGroup pantryLoc = (RadioGroup) findViewById(R.id.itemLoc);
                int newLoc = pantryLoc.getCheckedRadioButtonId();
                if (newLoc == 1) {

                } else {

                }

                EditText itemNotes = (EditText) findViewById(R.id.itemNotes);
                String newNote = itemNotes.getText().toString();
                pantryIntent.putExtra("Note", newNote);


                startActivity(pantryIntent);
            }
        });
    }
}