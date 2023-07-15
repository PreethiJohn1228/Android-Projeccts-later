package com.example.miniproj2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cnr1 extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cnr1);
        Bundle extras = getIntent().getExtras();
        String x = extras.getString("v1");
        TextView e = findViewById(R.id.textView28);
        e.setText(x);

        String y = extras.getString("v2");
        TextView e1 = findViewById(R.id.textView11);
        e1.setText(y);

        String z = extras.getString("v3");
        TextView e2 = findViewById(R.id.textView15);
        e2.setText(z);
    }
}

