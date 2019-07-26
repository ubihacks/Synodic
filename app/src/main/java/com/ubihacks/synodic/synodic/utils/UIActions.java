package com.ubihacks.synodic.synodic.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.R;

public class UIActions extends BaseActivity {

    public static void updateTime(String time)
    {
        TextView txtView = (TextView) ((Activity)UIUpdateContext).findViewById(R.id.txtTime);
        txtView.setText(time);
    }
    public static void updateDate(String date)
    {
        TextView txtView = (TextView) ((Activity)UIUpdateContext).findViewById(R.id.txtDate);
        txtView.setText(date);
    }

    public static void updateConnectionStatus(String status)
    {
        Log.w("UI", UIUpdateContext.getPackageName());
        TextView txtView = (TextView) ((Activity)UIUpdateContext).findViewById(R.id.txtConnectionStatus);
        txtView.setText(status);
    }

    static void updateDriverStatusOnUI()
    {
        TextView txtView = (TextView) ((Activity)UIUpdateContext).findViewById(R.id.txtDriverStatus);
        txtView.setText(actions.getCurrentDriverStatus().getDriverState());
    }

}
