package com.ubihacks.synodic.synodic;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.ubihacks.synodic.synodic.ACTIVITIES.BaseActivity;
import com.ubihacks.synodic.synodic.ACTIVITIES.Login;
import com.ubihacks.synodic.synodic.Fragments.BaseFragment;
import com.ubihacks.synodic.synodic.Fragments.Home;
import com.ubihacks.synodic.synodic.Fragments.Signature;
import com.ubihacks.synodic.synodic.Fragments.Status;
import com.ubihacks.synodic.synodic.MODEL.User;
import com.ubihacks.synodic.synodic.RECEIVERS.NetworkChangeReceiver;
import com.ubihacks.synodic.synodic.RECEIVERS.SocketDataReceiver;
import com.ubihacks.synodic.synodic.SERVICES.WebService;
import com.ubihacks.synodic.synodic.WEB_SOCKET.WEBSOCKET;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.MyApp.getContext;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_LOGGED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_TOKEN;

public class MainActivity extends BaseActivity {

    public static BaseFragment currentFragment;
    Drawer result;
    private Toolbar toolbar;
    private FrameLayout crossfadeContent;
    private AHBottomNavigation bottomNavigation;
    private CoordinatorLayout mainScreen;
    SocketDataReceiver dataReceiver = new SocketDataReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        RegisterNetworkReceiver();
        startService(new Intent(context, WebService.class));

        currentFragment = new Status();
        getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, currentFragment).commit();
        bottomNavigation(savedInstanceState);
        loadDrawer(savedInstanceState);

    }

    public static Context getMainContext()
    {
        return getContext();
    }

    private void RegisterSocketDataReceiver() {
        registerReceiver(dataReceiver, new IntentFilter("VEHICLE_ONLINE"));
    }
    private void UnregisterSocketDataReceiver() {
        unregisterReceiver(dataReceiver);
    }
    NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver(){
        @Override
        protected void onNetworkError() {
            super.onNetworkError();

            NoNetworkConnection(mainScreen);
        }
    };

    private void RegisterNetworkReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(100);
        registerReceiver(networkChangeReceiver,intentFilter);

    }
    private void UnegisterNetworkReceiver() {
        unregisterReceiver(networkChangeReceiver);

    }


    private void loadDrawer(Bundle savedInstanceState) {


        //Head
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false).
                        withHeaderBackground(R.color.accent)
                .withSavedInstance(savedInstanceState).addProfiles(

                )
                .build();


        //Drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)

                .withAccountHeader(headerResult)
                .withFullscreen(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Dashboard").withIdentifier(1),

                        new PrimaryDrawerItem().withName("Logout").withIdentifier(4)
                ).withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem != null) {
                            if (drawerItem.getIdentifier() == 1) {


                            } else if (drawerItem.getIdentifier() == 4) {
                                MyApp.getApi().logout().enqueue(new Callback<User>() {
                                    @Override
                                    public void onResponse(Call<User> call, Response<User> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<User> call, Throwable t) {

                                    }
                                });
                                prefs.saveToPrefs(KEY_LOGGED,false);
                                prefs.saveToPrefs(KEY_TOKEN,"");
                                startActivity(new Intent(MainActivity.this, Login.class));

                                finish();
                            }

                        }
                        return false;
                    }
                })
                .build();
    }


    private void bottomNavigation(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Logs", R.drawable.ic_logs);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Graphs", R.drawable.ic_graph);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Profile", R.drawable.ic_profile);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("VIR", R.drawable.ic_vir);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("Signature", R.drawable.ic_sign);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);

//        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#252f39"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // bottomNavigation.setForceTint(true);

        //bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setCurrentItem(0);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
                if (position == 0) {
                    currentFragment = new Status();
                }
                if (position == 1) {
                    currentFragment = new Home();
                }
                if (position == 4) {
                    currentFragment = new Signature();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, currentFragment).commit();

                return true;
            }
        });
    }


    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        crossfadeContent = (FrameLayout) findViewById(R.id.crossfade_content);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        mainScreen = (CoordinatorLayout) findViewById(R.id.mainScreen);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UnegisterNetworkReceiver();
    }
}
