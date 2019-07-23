package com.ubihacks.synodic.synodic.utils;


import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MainActivity;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class actions extends BaseActivity {

    public static DriverStatus statusDrivingResponse;
    private static DriverStatus currentDriverStatus = null;

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
                statusDrivingResponse = response.body();
                actions.setCurrentDriverStatus(statusDrivingResponse);
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
}
