package com.karobar.karobarcompany.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import static com.karobar.karobarcompany.Global.SharedPrefConstants.SharedPrefsVariables.APP_PREFERENCE_PASSWORD;


/**
 * Created by Mezzy on 10/22/2017.
 */

public class SharedPrefsHelper {

    private static SharedPrefsHelper sharedPrefsHelper;
    private Context context;
    private EncryptedPreferences encryptedPreferences;

    @SuppressLint("CommitPrefEdits")
    private SharedPrefsHelper(Context context) {
        this.context = context;
         encryptedPreferences = new EncryptedPreferences.Builder(context).withEncryptionPassword(APP_PREFERENCE_PASSWORD).build();
    }

    public static synchronized SharedPrefsHelper getInstance(Context context) {
        if (sharedPrefsHelper == null)
            sharedPrefsHelper = new SharedPrefsHelper(context);
        return sharedPrefsHelper;
    }

    public void setStringPref(String key, String value) {
        encryptedPreferences.edit().putString(key, value).apply();
    }

    public String getStringPref(String key) {
        String result = "n/a";
        if (encryptedPreferences != null)
            result = encryptedPreferences.getString(key, "");
        return result;
    }

    public void setIntegerPref(String key, int value) {
        encryptedPreferences.edit().putInt(key, value).apply();
    }

    public Integer getIntegerPref(String key) {
        int result = -1;
        if (encryptedPreferences != null)
            result = encryptedPreferences.getInt(key, -1);
        return result;
    }

    public void setFloatPref(String key, Float value) {
        encryptedPreferences.edit().putFloat(key, value).apply();
    }


    public Float getFloatPref(String key) {
        float result = 0;
        if (encryptedPreferences != null)
            result = encryptedPreferences.getFloat(key, -1);
        return result;
    }

    public void setBooleanPref(String key, Boolean value) {
        encryptedPreferences.edit().putBoolean(key, value).apply();
    }


    public Boolean getBooleanPref(String key) {
        Boolean result = false;
        if (encryptedPreferences != null)
            result = encryptedPreferences.getBoolean(key, false);
        return result;
    }


    public String convertToStringJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
