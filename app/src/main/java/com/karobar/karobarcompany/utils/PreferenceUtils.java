package com.karobar.karobarcompany.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import static com.karobar.karobarcompany.constants.SharedPrefsVariables.APP_PREFERENCE_PASSWORD;


/**
 * Created by Mezzy on 10/22/2017.
 */

public class PreferenceUtils {

    private static PreferenceUtils preferenceUtility;
    private Context context;
    private EncryptedPreferences encryptedPreferences;

    @SuppressLint("CommitPrefEdits")
    private PreferenceUtils(Context context) {
        this.context = context;
         encryptedPreferences = new EncryptedPreferences.Builder(context).withEncryptionPassword(APP_PREFERENCE_PASSWORD).build();
    }

    public static synchronized PreferenceUtils getInstance(Context context) {
        if (preferenceUtility == null)
            preferenceUtility = new PreferenceUtils(context);
        return preferenceUtility;
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
