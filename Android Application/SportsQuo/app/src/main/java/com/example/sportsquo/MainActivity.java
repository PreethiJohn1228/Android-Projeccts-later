package com.example.sportsquo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHandler db = new DataBaseHandler(this);

        // Inserting Contacts
        db.addAthlete(new Athlete("Rishi",20,175,60,"55","50","2","GRANDMASTER"));
        db.addAthlete(new Athlete("Nandhu",21,178,70,"40","39","1","CONQUEROR"));
        db.addAthlete(new Athlete("Rudhran",22,174,75,"30","28","1","STRATEGIST"));
        db.addAthlete(new Athlete("Nitin",22,172,58,"45","25","5","VETERAN"));
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        b1.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),Insert.class);
            startActivity(i);

        });
        b2.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),GetInfo.class);
            startActivity(i);

        });
        b3.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),Update.class);
            startActivity(i);

        });
        b4.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),Delete.class);
            startActivity(i);

        });


    }
}