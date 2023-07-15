package com.example.broadcast;


import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    InternetReceiver internetReceiver=new InternetReceiver();
    MyReceiver myReceiver=new MyReceiver();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button2);
        b2.setOnClickListener(v -> {
            //Intent intent=new Intent("com.example.broadcast.MYINTENT");
            //sendBroadcast(intent);
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivity(intent);
        });
        b1.setOnClickListener(v -> {
            registerReceiver(mMessageReceiver,new IntentFilter("com.example.broadcast.MYINTENT"));
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
        }
    };
    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BOOT_COMPLETED);
        registerReceiver(myReceiver, filter);
    }
    protected void onResume() {
        super.onResume();
        IntentFilter filter1 = new IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
        this.registerReceiver(internetReceiver, filter1);
        IntentFilter filter = new IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
        this.registerReceiver(internetReceiver, filter);
    }

    @Override
    public void onPause() {
        this.unregisterReceiver(internetReceiver);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

}