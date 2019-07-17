package com.ubihacks.synodic.synodic.API;



import com.ubihacks.synodic.synodic.MODEL.Device;
import com.ubihacks.synodic.synodic.MyApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by XSS on 11/04/2018.
 */

public class DataProvider {

    public List<Device> devicesList;

    public  void initializeDevices(final DataReceived dataReceived) {

        Api api = MyApp.getApi();

        final Call<List<Device>> deviceCall = api.getDevices();

        deviceCall.enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                devicesList = response.body();
                dataReceived.Success();
                // Send event here
            }
            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                devicesList = null;
            }
        });
    }

}
