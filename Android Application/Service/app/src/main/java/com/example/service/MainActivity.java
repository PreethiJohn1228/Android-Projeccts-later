package com.example.service;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickListener listener = new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                switch (view.getId()) {
                    case R.id.service_start:
                        //starts service for the given Intent
                        startService(intent);
                        break;
                    case R.id.service_stop:
                        //stops service for the given Intent
                        stopService(intent);
                        break;
                }
            }
        };
        findViewById(R.id.service_start).setOnClickListener(listener);
        findViewById(R.id.service_stop).setOnClickListener(listener);
    }
}