package com.ubihacks.synodic.synodic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.ACTIVITIES.Login;
import com.ubihacks.synodic.synodic.API.Api;
import com.ubihacks.synodic.synodic.API.DataReceived;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MODEL.User;
import com.ubihacks.synodic.synodic.utils.NetworkUtils;
import com.ubihacks.synodic.synodic.utils.actions;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_LOGGED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_TOKEN;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_DRIVING;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_OFF_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_ON_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_SLEEP;

public class SplashScreen extends BaseActivity {

    private ImageView splashIcon;
    private TextView splashText;
    protected Api api;
    protected Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        api = MyApp.getApi();

        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!NetworkUtils.internetRequired(this)) {
            return;
        } if(prefs.getBoolean(KEY_LOGGED)){
            Log.w("LOG", "KEY YES");
            // Refresh Cookies
            api.session(prefs.getString(KEY_TOKEN)).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    MyApp.user = response.body();
                    if(MyApp.user != null){
                        home();
                    } else {
                        login();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    login();
                }
            });

        } else{
            Log.w("LOG", "KEY NO");
            login();
        }
    }

    private void home() {

        MyApp.dataProvider.initializeDevices(new DataReceived() {
            @Override
            public void Success() {
                MyApp.dataProvider.getCurrentDriverStatus(new DataReceived() {
                    @Override
                    public void Success() {

                        MyApp.dataProvider.getCurrentDayDriverStatus(new DataReceived() {
                            @Override
                            public void Success() {
                                actions.calculateHOS();
                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        overridePendingTransition(R.anim.downtoup,R.anim.uptodown);
                                        finish();
                                    }
                                },500);
                            }
                        });
                    }
                });


            }
        });

    }

    private void login() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,Login.class));
                finish();
            }
        },1300);
    }


    private void initView() {

        splashIcon = (ImageView) findViewById(R.id.splashIcon);
        //splashText = (TextView) findViewById(R.id.splashText);
    }



}