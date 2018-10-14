package com.karobar.karobarcompany.dagger.component;

import android.app.Application;
import android.app.Fragment;

import com.karobar.karobarcompany.dagger.module.AppModule;
import com.karobar.karobarcompany.dagger.module.UtilsModule;
import com.karobar.karobarcompany.view.activities.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {

    void doInjection(LoginActivity activity);
    void doInjection(Fragment fragment);
    void donInjection(Application application);

}