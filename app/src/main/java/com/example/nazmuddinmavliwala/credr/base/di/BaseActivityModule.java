package com.example.nazmuddinmavliwala.credr.base.di;

import android.content.Context;

import com.example.nazmuddinmavliwala.credr.app.di.identifiers.ScopedActivity;
import com.example.nazmuddinmavliwala.credr.base.views.BaseActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

@ScopedActivity
@Module
public class BaseActivityModule {

    private BaseActivity activity;

    public BaseActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @ScopedActivity
    @Provides
    @Named("Activity")
    public Context provideContext() {
        return this.activity;
    }
}
