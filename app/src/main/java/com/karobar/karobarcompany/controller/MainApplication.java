package com.karobar.karobarcompany.controller;

import com.karobar.karobarcompany.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();
    }
    private void initTypeface() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Poppins-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
