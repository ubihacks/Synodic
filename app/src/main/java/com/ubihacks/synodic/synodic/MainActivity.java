package com.ubihacks.synodic.synodic;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.ubihacks.synodic.synodic.Fragments.BaseFragment;
import com.ubihacks.synodic.synodic.Fragments.Home;
import com.ubihacks.synodic.synodic.Fragments.Signature;
import com.ubihacks.synodic.synodic.Fragments.Status;

public class MainActivity extends AppCompatActivity {

    public static BaseFragment currentFragment;
    Drawer result;
    private Toolbar toolbar;
    private FrameLayout crossfadeContent;
    private AHBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        currentFragment = new Status();
        getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, currentFragment).commit();
        bottomNavigation(savedInstanceState);
        loadDrawer(savedInstanceState);


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

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Logs", R.drawable.ic_status);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Graphs", R.drawable.ic_status);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Profile", R.drawable.ic_mail_outline);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("VIR", R.drawable.ic_mail_outline);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("Signature", R.drawable.ic_mail_outline);

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
    }
}
