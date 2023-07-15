package com.example.carspecs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Chev extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chev);
        TextView t = findViewById(R.id.textView3);
        t.setText("*   The Chevrolet Corvette has 1 Petrol Engine on offer.\n" +
                "*   The Petrol engine is 6161 cc .\n" +
                "*   It is available with Automatic transmission.\n" +
                "*   Depending upon the variant and fuel type.\n" +
                "*   The Corvette has a mileage of 10.5 kmpl . \n" +
                "*   The Corvette is a 2 seater 8 cylinder car and has length of 4475mm, width of 1928mm");
        ImageButton b = findViewById(R.id.imageButton);
        b.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}

