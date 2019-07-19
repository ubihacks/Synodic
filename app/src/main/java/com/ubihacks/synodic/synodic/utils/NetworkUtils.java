package com.ubihacks.synodic.synodic.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.ubihacks.synodic.synodic.R;


/**
 * Created by Atiq on 8/12/2017.
 */

public class NetworkUtils {
    private Button networkSetting;
    private Button exitApp;

    public static boolean isConnectingToInternet(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    public static boolean internetRequired(final Activity activity) {

        if (!NetworkUtils.isConnectingToInternet(activity)) {

            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.network_error, null, false);
              /*HERE YOU CAN FIND YOU IDS AND SET TEXTS OR BUTTONS*/
            dialog.setContentView(view);

            dialog.setCancelable(false);
            final Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.CENTER);

            view.findViewById(R.id.exitApp).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
            view.findViewById(R.id.networkSetting).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new android.content.Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });

            dialog.show();

            return false;
        } else {
            return true;
        }
    }


}
