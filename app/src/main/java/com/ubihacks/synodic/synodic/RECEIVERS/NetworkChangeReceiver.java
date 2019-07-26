package com.ubihacks.synodic.synodic.RECEIVERS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.ubihacks.synodic.synodic.utils.NetworkUtils;
import com.ubihacks.synodic.synodic.utils.UIActions;
import com.ubihacks.synodic.synodic.utils.actions;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTERNET_CONNECTED_LABEL;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTERNET_DISCONNECTED_LABEL;
import static com.ubihacks.synodic.synodic.utils.NetworkUtils.NETWORK_STATUS_NOT_CONNECTED;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        if(NetworkUtils.getConnectivityStatus(context) == NETWORK_STATUS_NOT_CONNECTED)
        {
            actions.setCurrentConntectionStatus(INTERNET_DISCONNECTED_LABEL);
            UIActions.updateConnectionStatus(INTERNET_DISCONNECTED_LABEL);
        }
        if(NetworkUtils.getConnectivityStatus(context) == NetworkUtils.NETWORK_STATUS_MOBILE || NetworkUtils.getConnectivityStatus(context) == NetworkUtils.NETWORK_STATUS_WIFI)
        {
            actions.setCurrentConntectionStatus(INTERNET_CONNECTED_LABEL);
            UIActions.updateConnectionStatus(INTERNET_CONNECTED_LABEL);
        }
    }

    protected void onNetworkError() {}
    protected void onNetworkWork() {}
}
