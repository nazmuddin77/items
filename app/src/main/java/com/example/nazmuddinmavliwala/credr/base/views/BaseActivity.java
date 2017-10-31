package com.example.nazmuddinmavliwala.credr.base.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nazmuddinmavliwala.credr.app.CredRApp;
import com.example.nazmuddinmavliwala.credr.base.HasComponent;
import com.example.nazmuddinmavliwala.credr.base.di.BaseActivityComponent;
import com.example.nazmuddinmavliwala.credr.base.di.BaseActivityModule;
import com.example.nazmuddinmavliwala.credr.base.di.DaggerBaseActivityComponent;
import com.example.nazmuddinmavliwala.credr.base.di.RxModule;

import butterknife.ButterKnife;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<BaseActivityComponent> {

    private BaseActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        this.component = DaggerBaseActivityComponent.builder()
                .applicationComponent(CredRApp.getComponent())
                .baseActivityModule(new BaseActivityModule(this))
                .rxModule(new RxModule())
                .build();
        this.component.inject(this);
    }

    protected abstract int getLayout();

    @Override
    public BaseActivityComponent getComponent() {
        return this.component;
    }

}
