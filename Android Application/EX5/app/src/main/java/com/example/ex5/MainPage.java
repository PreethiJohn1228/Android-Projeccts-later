package com.example.ex5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        DataBaseHelper db = new DataBaseHelper(this);
        db.books(new Books("Cindrella","John",250,"26.08.2022","28.08.2022","Fantasy"));
        db.books(new Books("Life","James",210,"21.08.2022","23.08.2022","Fiction"));
        db.books(new Books("Wings of Fire","Robin",150,"02.07.2022","12.08.2022","Novel"));
        db.books(new Books("Java","Shahla",300,"15.06.2022","28.08.2022","Technical"));
        ImageButton b1=findViewById(R.id.imageButton3);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        ImageButton b4=findViewById(R.id.imageButton4);
        b1.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), Insert.class);
            startActivity(i);

        });
        b2.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), GetInfo.class);
            startActivity(i);

        });
        b3.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(), Update.class);
            startActivity(i);

        });
        b4.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(), Delete.class);
            startActivity(i);

        });


    }
}