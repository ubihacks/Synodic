package com.ubihacks.synodic.synodic.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;

/**
 * Created by Atiq on 5/7/2017.
 */

public class PrefUtils {

    Context context;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private static final String PREF_MAIN = "prefs_main";

    private static PrefUtils prefUtils;

    public static PrefUtils getInstance(Context context){
        if(prefUtils == null)
            prefUtils = new PrefUtils(context);

        return prefUtils;
    }

    public PrefUtils(Context context) {
        this.context = context;
        this.prefs =  context.getSharedPreferences(PREF_MAIN, Context.MODE_PRIVATE);
        this.editor = this.prefs.edit();
    }

    public void saveToPrefs(String key, String value){
        editor.putString(key,value);
        editor.commit();
    }
    public void saveToPrefs(String key, int value){
        editor.putInt(key,value);
        editor.commit();
    }
    public void saveToPrefs(String key, boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }
    public void saveToPrefs(String key, float value){
        editor.putFloat(key,value);
        editor.commit();
    }

    public void saveToPrefs(String key, long value){
        editor.putLong(key,value);
        editor.commit();
    }

    public void saveToPrefs(String key, String[] value){

        editor.putInt(key + "_size", value.length);
        for(int i=0;i<value.length; i++)
            editor.putString(key + "_" + i, value[i]);
        editor.commit();
    }

    public void saveToPrefs(String key, ArrayList<String> value){
        editor.putInt(key + "_size", value.size());
        for(int i=0;i<value.size(); i++)
            editor.putString(key + "_" + i, value.get(i));
        editor.commit();
    }

    public String[] getStringArray(String key){
        int size = prefs.getInt(key + "_size", 0);
        String[] array = new String[size];
        for(int i=0; i<size; i++)
            array[i] = prefs.getString(key + "_" + i, null);
        return array;
    }


    public String getString(String key){
        return prefs.getString(key,"");
    }

    public int getInt(String key){
        return prefs.getInt(key,0);
    }

    public boolean getBoolean(String key){
        return prefs.getBoolean(key,false);
    }

    public float getFloat(String key){
        return prefs.getFloat(key,0);
    }

    public long getLong(String key){
        return prefs.getLong(key,0);
    }


    public static void saveToPrefs(Context context, String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public static String getFromPrefs(Context context, String key, String defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getString(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
    public static void removeFromPrefs(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }



}