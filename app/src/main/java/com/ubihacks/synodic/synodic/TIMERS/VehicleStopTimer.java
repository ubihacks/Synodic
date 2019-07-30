package com.ubihacks.synodic.synodic.TIMERS;

import android.os.CountDownTimer;
import android.util.Log;

import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MainActivity;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.utils.Alerts;
import com.ubihacks.synodic.synodic.utils.actions;

import java.util.concurrent.CountDownLatch;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_OFF_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_ON_DUTY;

public class VehicleStopTimer extends CountDownTimer {


    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    public VehicleStopTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
        actions.setStopTimer(null);
        Alerts.statusChangeToOnDutyAlert();
        actions.updateDriverStatus(MyApp.dataProvider.selectedDevice.getId(), STATUS_ON_DUTY, "AUTOMATIC");
    }
}
