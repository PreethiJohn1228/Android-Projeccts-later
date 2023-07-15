package com.example.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{
    public static final String TAG = "TestService:";

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Log.d(TAG, "onReceive: boot completed");
            Toast.makeText(context.getApplicationContext(), "BOOT OCCURRED",Toast.LENGTH_LONG).show();
        }
    }
}