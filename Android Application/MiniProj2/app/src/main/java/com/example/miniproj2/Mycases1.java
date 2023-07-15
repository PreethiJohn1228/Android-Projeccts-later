package com.example.miniproj2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mycases1 extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycases1);
        Bundle extras = getIntent().getExtras();
        String x = extras.getString("v1");
        String a = extras.getString("v2");
        String b = extras.getString("v3");
        String c = extras.getString("v4");
        String d = extras.getString("v5");
        TextView e = findViewById(R.id.textView27);
        e.setText(x);
        TextView f = findViewById(R.id.textView4);
        f.setText(a);
        TextView g = findViewById(R.id.textView6);
        g.setText(b);
        TextView h = findViewById(R.id.textView9);
        h.setText(c);
        TextView j = findViewById(R.id.textView10);
        j.setText(d);


    }
}

