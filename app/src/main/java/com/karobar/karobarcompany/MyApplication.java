package com.karobar.karobarcompany;

import android.app.Application;
import android.content.Context;

import com.karobar.karobarcompany.dagger.component.AppComponent;
import com.karobar.karobarcompany.dagger.component.DaggerAppComponent;
import com.karobar.karobarcompany.dagger.module.AppModule;
import com.karobar.karobarcompany.dagger.module.UtilsModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application {
    AppComponent appComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
        initTypeface();
    }

    public AppComponent getAppComponent() {
        return appComponent;
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