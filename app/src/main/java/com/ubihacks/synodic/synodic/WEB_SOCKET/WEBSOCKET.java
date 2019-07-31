package com.ubihacks.synodic.synodic.WEB_SOCKET;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;
import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.MODEL.Device;
import com.ubihacks.synodic.synodic.MODEL.Event;
import com.ubihacks.synodic.synodic.MODEL.Position;
import com.ubihacks.synodic.synodic.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTENT_VEHICLE_MOVED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTENT_VEHICLE_ONLINE;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.INTENT_VEHICLE_STOPPED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.MESSAGE_TYPE_DEVICE;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.MESSAGE_TYPE_EVENTS;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.MESSAGE_TYPE_POSITION;
import static com.ubihacks.synodic.synodic.utils.actions.setLatestPosition;

public class WEBSOCKET implements WebSocketListener {
    JsonParser parser = null;
    Gson gson = null;
    Context context = null;
    @Override
    public void onStateChanged(com.neovisionaries.ws.client.WebSocket websocket, WebSocketState newState) throws Exception {

    }

    @Override
    public void onConnected(com.neovisionaries.ws.client.WebSocket websocket, Map<String, List<String>> headers) throws Exception {
        parser = new JsonParser();
        gson = new Gson();
        Log.w("INTENT", "CONNECTED");
        context = MainActivity.getMainContext();
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
        String messageType = message.split("\"")[1];
        Log.w("TAG", messageType);
        switch (messageType)
        {
            case MESSAGE_TYPE_POSITION:
            {
                JSONObject JsonObject = new JSONObject(message);
                JSONArray positionArray = JsonObject.getJSONArray("positions");
                JsonElement mJson =  parser.parse(positionArray.get(0).toString());
                Position position = gson.fromJson(mJson, Position.class);
                setLatestPosition(position);
                Log.w("TAG", position.getSpeed() + " is speed");
                generateVehicleMotionBroadcast(position);
            }
            break;
            case MESSAGE_TYPE_DEVICE:
            {
                JSONObject JsonObject = new JSONObject(message);
                JSONArray positionArray = JsonObject.getJSONArray("positions");
                JsonElement mJson =  parser.parse(positionArray.get(0).toString());
                Device device = gson.fromJson(mJson, Device.class);

            }
            break;
            case MESSAGE_TYPE_EVENTS:
            {
                JSONObject JsonObject = new JSONObject(message);
                JSONArray positionArray = JsonObject.getJSONArray("positions");
                JsonElement mJson =  parser.parse(positionArray.get(0).toString());
                Event event = gson.fromJson(mJson, Event.class);
                generateBroadcast(event);
            }
            break;
            default:
                Log.w("TAG", "NOT HANDLED");
        }
    }

    private void generateVehicleMotionBroadcast(Position position) {
        if(position.getSpeed() > -1)
        {
            context.sendBroadcast(new Intent(INTENT_VEHICLE_MOVED));
        }
        else
        {
            context.sendBroadcast(new Intent(INTENT_VEHICLE_STOPPED));
        }
    }

    private void generateBroadcast(Event event) {
        switch (event.getType())
        {
            case Event.TYPE_DEVICE_ONLINE:
            {
                context.sendBroadcast(new Intent(INTENT_VEHICLE_ONLINE));
            }
            break;
        }
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
}
