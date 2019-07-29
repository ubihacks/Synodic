package com.ubihacks.synodic.synodic.WEB_SOCKET;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.gson.Gson;
import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;
import com.ubihacks.synodic.synodic.MODEL.Position;
import com.ubihacks.synodic.synodic.MyApp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WEBSOCKET extends Service implements WebSocketListener {

    private WebSocket ws = null;


    @Override
    public void onStateChanged(com.neovisionaries.ws.client.WebSocket websocket, WebSocketState newState) throws Exception {

    }

    @Override
    public void onConnected(com.neovisionaries.ws.client.WebSocket websocket, Map<String, List<String>> headers) throws Exception {
            registerDataReceiver();
    }

    private void registerDataReceiver() {
    }

    @Override
    public void onConnectError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause) throws Exception {
        Log.d("TAG", "onTextMessage: " + cause.toString());
    }

    @Override
    public void onDisconnected(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {

    }

    @Override
    public void onFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onContinuationFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onTextFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onBinaryFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onCloseFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onPingFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onPongFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onTextMessage(com.neovisionaries.ws.client.WebSocket websocket, String message) throws Exception {
        Gson gson = new Gson();
        Log.d("TAG", "onTextMessage: " + message);
        Position position = gson.fromJson(message, Position.class);

        Intent intent = new Intent("newDataArrived");
        intent.putExtra("key", message);


        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

        Log.w("TAG", position.getDeviceTime().toString());
    }

    @Override
    public void onBinaryMessage(com.neovisionaries.ws.client.WebSocket websocket, byte[] binary) throws Exception {

    }

    @Override
    public void onSendingFrame(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onFrameSent(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onFrameUnsent(com.neovisionaries.ws.client.WebSocket websocket, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onThreadCreated(com.neovisionaries.ws.client.WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

    }

    @Override
    public void onThreadStarted(com.neovisionaries.ws.client.WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

    }

    @Override
    public void onThreadStopping(com.neovisionaries.ws.client.WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {

    }

    @Override
    public void onError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause) throws Exception {

    }

    @Override
    public void onFrameError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onMessageError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) throws Exception {

    }

    @Override
    public void onMessageDecompressionError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause, byte[] compressed) throws Exception {

    }

    @Override
    public void onTextMessageError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause, byte[] data) throws Exception {

    }

    @Override
    public void onSendError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {

    }

    @Override
    public void onUnexpectedError(com.neovisionaries.ws.client.WebSocket websocket, WebSocketException cause) throws Exception {

    }

    @Override
    public void handleCallbackError(com.neovisionaries.ws.client.WebSocket websocket, Throwable cause) throws Exception {

    }

    @Override
    public void onSendingHandshake(WebSocket websocket, String requestLine, List<String[]> headers) throws Exception {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.w("SERVICE", "STARTED");
        WebSocketFactory factory = new WebSocketFactory().setConnectionTimeout(5000);


        try {
            final String COOKIES = "COOKIES";
            String cookie = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext().getApplicationContext()).getStringSet(COOKIES,null).toString().split(";")[0].substring(1);
            Log.w("TAG", "Cookie is " + cookie);
            ws = factory.createSocket("ws://192.168.10.30:8082/api/socket");
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
        Intent restartService = new Intent("RestartService");
        sendBroadcast(restartService);
    }
}
