package com.ubihacks.synodic.synodic.RECEIVERS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SocketDataReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("key");
        Log.w("TAGR", message);
    }
}
