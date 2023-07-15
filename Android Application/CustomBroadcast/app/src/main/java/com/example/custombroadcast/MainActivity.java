package com.example.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.actions.NoteIntents;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button2);
        b2.setOnClickListener(v -> {
            Intent intent=new Intent("com.example.custombroadcast.MYINTENT");
            sendBroadcast(intent);
        });
        b1.setOnClickListener(v -> {
            registerReceiver(mMessageReceiver,new IntentFilter("com.example.custombroadcast.MYINTENT"));
        });
    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Extract data included in the Intent
            String message = intent.getAction();
            String msg="Alert";
            String hour="12";
            String minutes="20";

            Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
//            Intent i  = new Intent(Settings.ACTION_WIFI_SETTINGS);
//            startActivity(intent);
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("content://contacts/people/"));
            startActivity(i);


        }
    };
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mMessageReceiver);
    }
}