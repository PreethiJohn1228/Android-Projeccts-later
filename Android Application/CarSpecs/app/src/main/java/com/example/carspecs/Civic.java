package com.example.carspecs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Civic extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civic);
        TextView t = findViewById(R.id.textView3);
        t.setText("*   The Honda Civic has 1 Diesel Engine and 1 Petrol Engine on offer.\n" +
                "*   The Diesel engine is 1597 cc while the Petrol engine is 1799 cc .\n" +
                "*   It is available with Manual & Automatic transmission.\n" +
                "*   Depending upon the variant and fuel type the Civic has a mileage of 16.5 to 26.8 kmpl.\n" +
                "*   The Civic is a 5 seater 4 cylinder car and has length of 4656 mm, width of 1799 mm and a wheelbase of 2700 mm.");
        ImageButton b=findViewById(R.id.imageButton2);
        b.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}
