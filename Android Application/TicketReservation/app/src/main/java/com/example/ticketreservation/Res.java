package com.example.ticketreservation;

import static com.example.ticketreservation.R.id.textView12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Res extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res);
        Bundle extras = getIntent().getExtras();
        String x = extras.getString("v1");
        TextView e = findViewById(R.id.textView12);
        e.setText(x);
    }

}
