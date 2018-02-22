package com.example.tyc.roomtest.DI;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by CarTek on 2018/2/22.
 */
@Module
public abstract class AppModule {

    @Binds
    abstract Context provideContext(Application application);

}
