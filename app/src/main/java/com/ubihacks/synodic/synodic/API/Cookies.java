package com.ubihacks.synodic.synodic.API;

import android.preference.PreferenceManager;
import com.ubihacks.synodic.synodic.MyApp;

import java.util.HashSet;


/**
 * Created by Atiq on 4/10/2018.
 */

public abstract class Cookies {

    private static final String COOKIES = "COOKIES";

    public static void addCookies(HashSet<String> cookies){
        PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()).edit().putStringSet(COOKIES,cookies).apply();
    }
    public static HashSet<String> getCookies() {
        return (HashSet) PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()).getStringSet(COOKIES,null);
    }

    public static boolean cookiesExist(){
        HashSet<String> cookies = getCookies();
        return (cookies != null || cookies.size() > 0);
    }

    // Logout

    public static void deleteCookies(){
        PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()).edit().remove(COOKIES).apply();
    }

}
