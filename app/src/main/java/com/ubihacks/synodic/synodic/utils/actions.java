package com.ubihacks.synodic.synodic.utils;


import android.util.Log;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MODEL.Position;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.TIMERS.VehicleDriveTimer;
import com.ubihacks.synodic.synodic.TIMERS.VehicleStopTimer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_DRIVING;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_OFF_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_ON_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_SLEEP;
import static com.ubihacks.synodic.synodic.utils.UIActions.updateDriverStatusOnUI;


public class actions extends BaseActivity {
    public static DriverStatus statusResponse = null;
    private static DriverStatus currentDriverStatus = null;
    private static List<DriverStatus> currentDayStatuses = null;
    private static String currentConntectionStatus = null;
    private static long timeDriving = 0, timeSleeping = 0, timeOnDuty = 0, timeOffDuty = 0;
    private static Position latestPosition = null;
    private static VehicleDriveTimer driverTimer = null;
    private static VehicleStopTimer stopTimer = null;

    public static VehicleStopTimer getStopTimer() {
        return stopTimer;
    }

    public static void setStopTimer(VehicleStopTimer stopTimer) {
        actions.stopTimer = stopTimer;
    }

    public static VehicleDriveTimer getDriverTimer() {
        return driverTimer;
    }

    public static void setDriverTimer(VehicleDriveTimer driverTimer) {
        actions.driverTimer = driverTimer;
    }

    public static Position getLatestPosition() {
        return latestPosition;
    }

    public static void setLatestPosition(Position latestPosition) {
        actions.latestPosition = latestPosition;
    }

    public static String getCurrentConntectionStatus() {
        return currentConntectionStatus;
    }

    public static void setCurrentConntectionStatus(String currentConntectionStatus) {
        actions.currentConntectionStatus = currentConntectionStatus;
    }

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
                updateDriverStatusOnUI();
            }
            @Override
            public void onFailure(Call<DriverStatus> call, Throwable t) {
                statusResponse = null;
            }
        });
        return statusResponse;
    }

    public static void fetchGPSLocation()
    {

    }

    public static void calculateHOS()
    {
        timeDriving = timeOffDuty = timeOnDuty = timeSleeping = 0;

        List<DriverStatus> statuses = actions.getCurrentDayStatuses();
        Log.w("STATUS", "SIZE " + statuses.size());
        int iterator = 1;
        for (DriverStatus st: statuses) {
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
