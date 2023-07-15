package com.example.sportsquo;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        EditText e=findViewById(R.id.editTextTextPersonName10);
        ImageButton b=findViewById(R.id.imageButton);
        b.setOnClickListener(v -> {
            String name=e.getText().toString();
            DataBaseHandler db=new DataBaseHandler(this);
            db.deleteAthlete(name);
            Toast.makeText(getApplicationContext(),"Deleted Successfully!",Toast.LENGTH_SHORT).show();
        });
    }
}
