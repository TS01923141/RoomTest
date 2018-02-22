package com.example.cartek.androidarchitecturecomponentstest.DI;

import android.app.Application;

import com.example.cartek.androidarchitecturecomponentstest.MainApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by CarTek on 2018/2/22.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        BuilderModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MainApp app);

    @Override
    void inject(DaggerApplication daggerApplication);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
