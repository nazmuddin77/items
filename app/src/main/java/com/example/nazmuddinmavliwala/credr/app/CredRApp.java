package com.example.nazmuddinmavliwala.credr.app;

import android.app.Application;

import com.example.nazmuddinmavliwala.credr.app.di.ApplicationComponent;
import com.example.nazmuddinmavliwala.credr.app.di.ApplicationModule;
import com.example.nazmuddinmavliwala.credr.app.di.DaggerApplicationComponent;
import com.example.nazmuddinmavliwala.credr.app.di.DataModule;


/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public class CredRApp extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
        component.inject(this);
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
