package com.example.carspecs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Corolla extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corolla);
        TextView t = findViewById(R.id.textView3);
        t.setText("*   The Toyota Corolla has 1 Petrol Engine on offer.\n" +
                "*   The Petrol engine is 1794 cc . It is available with Manual & Automatic transmission.\n" +
                "*   Depending upon the variant and fuel type.\n" +
                "*   The Corolla has a mileage of 11.3 to 13.4 kmpl & Ground clearance of Corolla is 170 mm. \n" +
                "*   The Corolla is a 5 seater 4 cylinder car and has length of 4,530 mm, width of 1,705 mm and a wheelbase of 2,600 mm.");
        ImageButton b=findViewById(R.id.imageButton3);
        b.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}
