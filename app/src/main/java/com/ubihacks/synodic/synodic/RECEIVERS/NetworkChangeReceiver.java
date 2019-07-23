package com.ubihacks.synodic.synodic.RECEIVERS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.ubihacks.synodic.synodic.utils.NetworkUtils;

import static com.ubihacks.synodic.synodic.utils.NetworkUtils.NETWORK_STATUS_NOT_CONNECTED;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        if(NetworkUtils.getConnectivityStatus(context) == NETWORK_STATUS_NOT_CONNECTED)
        {
            Toast.makeText(context, "Disconnected from internet", Toast.LENGTH_SHORT).show();
        }
        if(NetworkUtils.getConnectivityStatus(context) == NetworkUtils.NETWORK_STATUS_MOBILE || NetworkUtils.getConnectivityStatus(context) == NetworkUtils.NETWORK_STATUS_WIFI)
        {
            Toast.makeText(context, "Connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onNetworkError() {}
    protected void onNetworkWork() {}
}
