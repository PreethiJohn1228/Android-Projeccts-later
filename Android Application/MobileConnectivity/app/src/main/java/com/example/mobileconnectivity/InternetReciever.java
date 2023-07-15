package com.example.mobileconnectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternetReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status = Networkstatus.getConnectivityStatusString(context);

        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }
}
