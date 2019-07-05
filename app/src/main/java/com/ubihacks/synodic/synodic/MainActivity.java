package com.ubihacks.synodic.synodic;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.ubihacks.synodic.synodic.Fragments.BaseFragment;
import com.ubihacks.synodic.synodic.Fragments.Home;

public class MainActivity extends AppCompatActivity {

    public static BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragment = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, currentFragment).commit();
        bottomNavigation(savedInstanceState);
    }




    private void bottomNavigation(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Status",R.drawable.ic_mail_outline);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Graphs", R.drawable.ic_mail_outline);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Logs", R.drawable.ic_mail_outline);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Setting", R.drawable.ic_mail_outline);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("", R.drawable.ic_mail_outline);

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

        bottomNavigation.setCurrentItem(1);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
                if (position == 0) {
                    currentFragment = new Home();
                }
                if (position == 1) {
                    currentFragment = new Home();
                }
                if (position == 2) {
                    currentFragment = new Home();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, currentFragment).commit();

                return true;
            }
        });
    }
}
