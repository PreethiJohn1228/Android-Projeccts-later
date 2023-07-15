package com.example.alarmservice;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmReceiver alarm = new AlarmReceiver();
        alarm.setAlarm(this);
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MakeMyToast.class);
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