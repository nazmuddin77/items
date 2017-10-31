package com.example.nazmuddinmavliwala.credr.base.di;

import android.content.Context;

import com.example.data.network.NetworkService;
import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;
import com.example.nazmuddinmavliwala.credr.app.di.ApplicationComponent;
import com.example.nazmuddinmavliwala.credr.app.di.identifiers.ScopedActivity;
import com.example.nazmuddinmavliwala.credr.base.views.BaseActivity;
import com.example.nazmuddinmavliwala.credr.ui.items.di.ItemComponent;
import com.example.nazmuddinmavliwala.credr.ui.items.di.ItemModule;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

@ScopedActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                BaseActivityModule.class,
                RxModule.class
        }
)
public interface BaseActivityComponent {

    @Named("Activity")
    Context provideActivityContext();

    ExecutionThread provideExecutionThread();

    PostExecutionThread providePostExecutionThread();

    NetworkService provideNetworkService();

    void inject(BaseActivity activity);

    ItemComponent provideItemComponent(ItemModule module);

}
