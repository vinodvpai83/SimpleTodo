package com.example.vpai.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        String editItemText = getIntent().getStringExtra("editItemText");
        etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText(editItemText);
        etEditItem.setSelection(editItemText.length());
    }

    public void saveEditedItem(View view) {
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editedItemText", etEditItem.getText().toString());
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
