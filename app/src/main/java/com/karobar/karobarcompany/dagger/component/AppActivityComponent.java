package com.karobar.karobarcompany.dagger.component;

import com.karobar.karobarcompany.dagger.module.AppModule;
import com.karobar.karobarcompany.dagger.module.UtilsModule;
import com.karobar.karobarcompany.view.activities.LoginActivity;
import com.karobar.karobarcompany.view.activities.RegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppActivityComponent {

    void doInjection(LoginActivity activity);

    void doInjection(RegisterActivity activity);

}