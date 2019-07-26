package com.ubihacks.synodic.synodic.utils;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_DRIVING;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_OFF_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_ON_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_SLEEP;


public class actions extends BaseActivity {

    public static DriverStatus statusResponse = null;
    private static DriverStatus currentDriverStatus = null;
    private static List<DriverStatus> currentDayStatuses = null;
    private static long timeDriving = 0, timeSleeping = 0, timeOnDuty = 0, timeOffDuty = 0;

    public static long getTimeDriving() {
        return timeDriving;
    }

    public static void setTimeDriving(long timeDriving) {
        actions.timeDriving = timeDriving;
    }

    public static long getTimeSleeping() {
        return timeSleeping;
    }

    public static void setTimeSleeping(long timeSleeping) {
        actions.timeSleeping = timeSleeping;
    }

    public static long getTimeOnDuty() {
        return timeOnDuty;
    }

    public static void setTimeOnDuty(long timeOnDuty) {
        actions.timeOnDuty = timeOnDuty;
    }

    public static long getTimeOffDuty() {
        return timeOffDuty;
    }

    public static void setTimeOffDuty(long timeOffDuty) {
        actions.timeOffDuty = timeOffDuty;
    }

    public static List<DriverStatus> getCurrentDayStatuses() {
        return currentDayStatuses;
    }

    public static void setCurrentDayStatuses(List<DriverStatus> currentDayStatuses) {
        actions.currentDayStatuses = currentDayStatuses;
    }

    public static DriverStatus getCurrentDriverStatus() {
        return currentDriverStatus;
    }

    public static void setCurrentDriverStatus(DriverStatus currentDriverStatus) {
        actions.currentDriverStatus = currentDriverStatus;
    }

    public static DriverStatus updateDriverStatus(int deviceId, String driverStatus, final String driverComment)
    {
        DriverStatus st = new DriverStatus();
        st.setDriverState(driverStatus);
        st.setDeviceId(deviceId);
        st.setDriverComment(driverComment);

        final Call<DriverStatus> statusCall = MyApp.getApi().setDriverStatus(st);
        statusCall.enqueue(new Callback<DriverStatus>() {
            @Override
            public void onResponse(Call<DriverStatus> call, Response<DriverStatus> response) {
                statusResponse = response.body();
                actions.setCurrentDriverStatus(statusResponse);
                updateDriverStatusOnUI(UIUpdateContext);
            }
            @Override
            public void onFailure(Call<DriverStatus> call, Throwable t) {
            }
        });
        return null;
    }

    public static void fetchGPSLocation()
    {

    }

    static void updateDriverStatusOnUI(Context context)
    {
        TextView txtView = (TextView) ((Activity)context).findViewById(R.id.txtDriverStatus);
        txtView.setText(actions.getCurrentDriverStatus().getDriverState());
    }

    public static void calculateHOS()
    {
        int iterator = 1;
        for (DriverStatus st: actions.getCurrentDayStatuses()) {
            Log.w("STATUS", "TYPE: " + st.getDriverState() + "STATUS TIME: " + st.getServerTime());
            if( iterator < actions.getCurrentDayStatuses().size()) {
                if (st.getDriverState().equals(STATUS_DRIVING)) {
                    timeDriving += actions.getCurrentDayStatuses().get(iterator).getServerTime().getTime() - st.getServerTime().getTime();
                    Log.w("TIME", "TIME: " + timeDriving + "");
                }
                if (st.getDriverState().equals(STATUS_ON_DUTY)) {
                    timeOnDuty += actions.getCurrentDayStatuses().get(iterator).getServerTime().getTime() - st.getServerTime().getTime();
                }
                if (st.getDriverState().equals(STATUS_OFF_DUTY)) {
                    timeOffDuty += actions.getCurrentDayStatuses().get(iterator).getServerTime().getTime() - st.getServerTime().getTime();
                }
                if (st.getDriverState().equals(STATUS_SLEEP)) {
                    timeSleeping += actions.getCurrentDayStatuses().get(iterator).getServerTime().getTime() - st.getServerTime().getTime();
                }
            }
            iterator++;
        }
    }

    public static String longToTimeString(long totalSecs)
    {
        //Log.w("TIME", "" + totalSecs);
        totalSecs /= 1000;  //Milliseconds to seconds
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
