package com.ubihacks.synodic.synodic;

import android.app.Application;
import android.content.Context;

import com.ubihacks.synodic.synodic.API.Api;
import com.ubihacks.synodic.synodic.API.ApiClient;
import com.ubihacks.synodic.synodic.API.DataProvider;
import com.ubihacks.synodic.synodic.MODEL.User;


/**
 * Created by Ubaid on 4/10/2018.
 */
public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }


    public static Context getContext(){
        return instance;
    }

    public static Api getApi(){
        return ApiClient.getClient().create(Api.class);
    }

    public static DataProvider dataProvider = new DataProvider();

    public static User user;

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

//    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
//        ConnectivityReceiver.connectivityReceiverListener = listener;
//    }

}