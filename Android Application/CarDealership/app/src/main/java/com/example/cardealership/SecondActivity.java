package com.example.cardealership;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    static TextView t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        t=findViewById(R.id.textView8);
        Bundle Extras=getIntent().getExtras();
        String res=Extras.getString("v1");
        t.setText(res);
    }
}
