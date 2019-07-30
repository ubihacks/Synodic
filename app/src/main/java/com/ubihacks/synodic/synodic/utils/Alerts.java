package com.ubihacks.synodic.synodic.utils;

import android.content.Context;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.MainActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Alerts extends BaseActivity {
    public static void statusChangeToOnDutyAlert()
    {
        final SweetAlertDialog sweetAlertDialog =  new SweetAlertDialog(UIUpdateContext,
                SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("STATUS CHANGE");
        sweetAlertDialog.setContentText("Vehicle is stopped. Changing status to On-Duty");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }
    public static void statusChangeToDrivingAlert()
    {
        final SweetAlertDialog sweetAlertDialog =  new SweetAlertDialog(UIUpdateContext,
                SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("STATUS CHANGE");
        sweetAlertDialog.setContentText("Vehicle is in motion. Changing status to Driving");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    public static void statusUpdatedSuccess()
    {
        final SweetAlertDialog sweetAlertDialog =  new SweetAlertDialog(UIUpdateContext,
                SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("STATUS UPDATE");
        sweetAlertDialog.setContentText("Driver status updated");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    public static void statusUpdatedFailed()
    {
        final SweetAlertDialog sweetAlertDialog =  new SweetAlertDialog(UIUpdateContext,
                SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("STATUS UPDATE");
        sweetAlertDialog.setContentText("Failed to update driver status");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }
}
