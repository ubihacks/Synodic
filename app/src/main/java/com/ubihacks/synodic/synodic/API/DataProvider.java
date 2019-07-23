package com.ubihacks.synodic.synodic.API;


import android.util.Log;

import com.ubihacks.synodic.synodic.MODEL.Device;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.utils.actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                Log.w("OK", response.toString());
                List<DriverStatus> statuses = response.body();
                actions.setCurrentDriverStatus(statuses.get(0));
                dataReceived.Success();
            }

            @Override
            public void onFailure(Call<List<DriverStatus>> call, Throwable t) {
                Log.w("OK", t.toString());
                actions.setCurrentDriverStatus(null);
            }
        });
    }

}
