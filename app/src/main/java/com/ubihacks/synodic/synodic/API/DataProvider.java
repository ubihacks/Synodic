package com.ubihacks.synodic.synodic.API;


import android.util.Log;

import com.ubihacks.synodic.synodic.MODEL.Device;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.utils.DateUtils;
import com.ubihacks.synodic.synodic.utils.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.utils.actions.setCurrentDayStatuses;


/**
 * Created by XSS on 11/04/2018.
 */

public class DataProvider {

    public List<Device> devicesList;
    public Device selectedDevice;
    Api api = MyApp.getApi();

    public void initializeDevices(final DataReceived dataReceived) {

        final Call<List<Device>> deviceCall = api.getDevices();

        deviceCall.enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                devicesList = response.body();
                selectedDevice = devicesList.get(0);
                dataReceived.Success();
                // Send event here
            }


            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                devicesList = null;
            }
        });
    }

    public void getCurrentDriverStatus(final DataReceived dataReceived) {
        final Call<List<DriverStatus>> currentDriverStatus = api.getCurrentDriverStatus(selectedDevice.getId());

        currentDriverStatus.enqueue(new Callback<List<DriverStatus>>() {
            @Override
            public void onResponse(Call<List<DriverStatus>> call, Response<List<DriverStatus>> response) {
                List<DriverStatus> statuses = response.body();
                actions.setCurrentDriverStatus(statuses.get(0));
                dataReceived.Success();
            }

            @Override
            public void onFailure(Call<List<DriverStatus>> call, Throwable t) {
                actions.setCurrentDriverStatus(null);
            }
        });
    }

    public void getCurrentDayDriverStatus(final DataReceived dataReceived) {
        final Calendar from = Calendar.getInstance();
        from.set(Calendar.HOUR_OF_DAY, 0);
        from.set(Calendar.MINUTE, 0);
        from.set(Calendar.SECOND, 0);

        final Calendar to = Calendar.getInstance();

        Log.w("DATE", "FROM: " + DateUtils.getISO8601StringForDate(from.getTime()));
        Log.w("DATE", "TO: " + DateUtils.getISO8601StringForDate(to.getTime()));
        final Call<List<DriverStatus>> todayStatuses = api.getDriverStatus(selectedDevice.getId(), DateUtils.getISO8601StringForDate(from.getTime()), DateUtils.getISO8601StringForDate(to.getTime()));

        todayStatuses.enqueue(new Callback<List<DriverStatus>>() {
            @Override
            public void onResponse(Call<List<DriverStatus>> call, Response<List<DriverStatus>> response) {
                setCurrentDayStatuses(response.body());
                dataReceived.Success();
            }

            @Override
            public void onFailure(Call<List<DriverStatus>> call, Throwable t) {
                setCurrentDayStatuses(null);
            }
        });
    }

}
