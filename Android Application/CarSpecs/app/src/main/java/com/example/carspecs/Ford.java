package com.example.carspecs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ford extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ford);
        ImageButton b=findViewById(R.id.imageButton4);
        TextView t = findViewById(R.id.textView3);
        t.setText("*   Engine TypeFlex-fuel (FFV)\n" +
                "*   Transmission6-speed shiftable automatic\n" +
                "*   Drive TypeFront wheel drive\n" +
                "*   CylindersV6\n" +
                "*   Total Seating5\n" +
                "*   Basic Warranty3 yr./ 36,000 mi.");
        b.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}
