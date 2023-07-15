package com.example.ex5;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        EditText e=findViewById(R.id.editTextTextPersonName10);
        Button b=findViewById(R.id.button7);
        b.setOnClickListener(v -> {
            String name=e.getText().toString();
            DataBaseHelper db=new DataBaseHelper(this);
            db.deleteBooks(name);
            Toast.makeText(getApplicationContext(),"Deleted Successfully!",Toast.LENGTH_SHORT).show();
        });
    }
}
