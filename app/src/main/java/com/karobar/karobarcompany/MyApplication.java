package com.karobar.karobarcompany;

import android.app.Application;
import android.content.Context;

import com.karobar.karobarcompany.dagger.component.AppActivityComponent;
import com.karobar.karobarcompany.dagger.component.DaggerAppActivityComponent;
import com.karobar.karobarcompany.dagger.module.AppModule;
import com.karobar.karobarcompany.dagger.module.UtilsModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application {
    AppActivityComponent appActivityComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appActivityComponent = DaggerAppActivityComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
        initTypeface();
    }

    public AppActivityComponent getAppActivityComponent() {
        return appActivityComponent;
    }

    private void initTypeface() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Poppins-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }
}