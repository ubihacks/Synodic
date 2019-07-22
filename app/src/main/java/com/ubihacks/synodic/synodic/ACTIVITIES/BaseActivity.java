package com.ubihacks.synodic.synodic.ACTIVITIES;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.API.Api;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.utils.PrefUtils;

/**
 * Created by ubaid on 2/24/2019.
 */

public class BaseActivity extends AppCompatActivity {

    protected PrefUtils prefs;
    protected Api api;
    protected Context context;
    Snackbar snackbar;
    public static Context UIUpdateContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PrefUtils.getInstance(this);
        api = MyApp.getApi();
        context = getApplicationContext();
    }


    protected void ErrorSnackbar(CoordinatorLayout main){
        snackbar = Snackbar
                .make(main, "No internet connection!", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });


// Changing message text color
        snackbar.setActionTextColor(Color.WHITE);

// Changing action button text color
        View view = snackbar.getView();
        view.setBackgroundColor(Color.RED);
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();

    }
}
