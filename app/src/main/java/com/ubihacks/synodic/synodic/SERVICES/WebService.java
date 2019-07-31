package com.ubihacks.synodic.synodic.SERVICES;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.WEB_SOCKET.WEBSOCKET;

import java.io.IOException;

public class WebService extends Service {

    private static WebSocket ws = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        WebSocketFactory factory = new WebSocketFactory().setConnectionTimeout(5000);

        try {
            final String COOKIES = "COOKIES";
            String cookie = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext().getApplicationContext()).getStringSet(COOKIES,null).toString().split(";")[0].substring(1);
            ws = factory.createSocket("ws://testeld.gatsan.com/api/socket");
            ws.addHeader("Cookie", cookie);
            ws.addListener(new WEBSOCKET());

            ws.connectAsynchronously();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("INTENT", "RESTART");
        Intent restartService = new Intent("RestartService");
        sendBroadcast(restartService);
    }
}
