package com.ubihacks.synodic.synodic.TIMERS;

import android.os.CountDownTimer;
import android.util.Log;

import com.ubihacks.synodic.synodic.utils.actions;

public class VehicleDriveTimer extends CountDownTimer {


    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    public VehicleDriveTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Log.w("TIMER", "TICKING");
    }

    @Override
    public void onFinish() {
        actions.setDriverTimer(null);
        Log.w("TIMER", "FINISHED");
    }
}
