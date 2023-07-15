package com.example.miniproj2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Search1 extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search1);
        Bundle extras = getIntent().getExtras();
        String x = extras.getString("v1");
        TextView e = findViewById(R.id.textView28);
        e.setText(x);

        String z = extras.getString("v3");
        TextView e2 = findViewById(R.id.textView15);
        e2.setText(z);
    }
}

