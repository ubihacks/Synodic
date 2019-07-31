package com.ubihacks.synodic.synodic.RECEIVERS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.TIMERS.VehicleStopTimer;
import com.ubihacks.synodic.synodic.utils.Alerts;
import com.ubihacks.synodic.synodic.utils.actions;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTENT_VEHICLE_MOVED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTENT_VEHICLE_STOPPED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_DRIVING;

public class SocketDataReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(actions.getCurrentDriverStatus() != null) {
            Log.w("TAG", intent.getAction() + " AND " + actions.getCurrentDriverStatus().getDriverState());
            if (INTENT_VEHICLE_MOVED.equals(intent.getAction()) && (!actions.getCurrentDriverStatus().equals(STATUS_DRIVING))) {
                Log.w("TAG", "SHOWING ALERT");
                Alerts.statusChangeToDrivingAlert();
                actions.updateDriverStatus(MyApp.dataProvider.selectedDevice.getId(), STATUS_DRIVING, "AUTOMATIC");
            }
            if (INTENT_VEHICLE_STOPPED.equals(intent.getAction()) && actions.getCurrentDriverStatus().getDriverState().equals(STATUS_DRIVING)) {
                if (actions.getStopTimer() == null) {
                    Log.w("TAG", "STARTING TIMER FOR STATUS CHANGE");
                    actions.setStopTimer(new VehicleStopTimer(1000, 200));
                    actions.getStopTimer().start();
                } else {
                    Log.w("TIMER", "ALREADY STARTED");
                }
            }
        }
        else
        {
            //Show notification
        }
    }
}
