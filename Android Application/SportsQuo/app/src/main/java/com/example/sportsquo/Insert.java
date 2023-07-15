package com.example.sportsquo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Insert extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        EditText e1=findViewById(R.id.editTextTextPersonName2);
        EditText e2=findViewById(R.id.editTextTextPersonName3);
        EditText e3=findViewById(R.id.editTextTextPersonName4);
        EditText e4=findViewById(R.id.editTextTextPersonName5);
        EditText e5=findViewById(R.id.editTextTextPersonName6);
        EditText e6=findViewById(R.id.editTextTextPersonName7);
        EditText e7=findViewById(R.id.editTextTextPersonName8);
        EditText e8=findViewById(R.id.editTextTextPersonName9);
        Button b=findViewById(R.id.button6);
        b.setOnClickListener(v -> {
            DataBaseHandler db=new DataBaseHandler(this);
            String name=e1.getText().toString();
            int age=Integer.parseInt(e2.getText().toString());
            int height=Integer.parseInt(e3.getText().toString());
            int weight=Integer.parseInt(e4.getText().toString());
            String played=e5.getText().toString();
            String won=e6.getText().toString();
            String best=e7.getText().toString();
            String title=e8.getText().toString();
            Athlete a=new Athlete(name,age,height,weight,played,won,best,title);
            db.addAthlete(a);
            Toast.makeText(getApplicationContext(),"Inserted Successfully!", Toast.LENGTH_SHORT).show();

        });


    }
}
