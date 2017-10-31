package com.example.nazmuddinmavliwala.credr.app.di;

import android.content.Context;

import com.example.data.network.NetworkService;
import com.example.nazmuddinmavliwala.credr.app.CredRApp;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class
        }
)
public interface ApplicationComponent {

    @Named("Application")
    Context provideApplicationContext();

    NetworkService provideNetworkService();

    void inject(CredRApp app);
}
