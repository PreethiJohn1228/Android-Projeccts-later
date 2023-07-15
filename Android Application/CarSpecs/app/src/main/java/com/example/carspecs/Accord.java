package com.example.carspecs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Accord extends AppCompatActivity {
    ImageButton b;
    TextView t=findViewById(R.id.textView3);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accord);
        t.setText("*   The Honda Accord has 2 Petrol Engine on offer. \n" +
                "*   The Petrol engine is 1993 cc and 3471 cc.\n" +
                "*   It is available with Automatic transmission.\n" +
                "*   Depending upon the variant and fuel type.\n" +
                "*   The Accord has a mileage of 10.7 to 23.1 kmpl & Ground clearance of Accord is 155mm. \n" +
                "*   The Accord is a 5 seater 6 cylinder car and has length of 4950mm, width of 1845mm and a wheelbase of 2800mm.");
        b=findViewById(R.id.imageButton5);
        b.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}
