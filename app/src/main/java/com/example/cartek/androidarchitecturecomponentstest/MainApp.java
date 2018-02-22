package com.example.cartek.androidarchitecturecomponentstest;

import com.example.cartek.androidarchitecturecomponentstest.DI.AppComponent;
import com.example.cartek.androidarchitecturecomponentstest.DI.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by CarTek on 2018/2/22.
 */

public class MainApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
