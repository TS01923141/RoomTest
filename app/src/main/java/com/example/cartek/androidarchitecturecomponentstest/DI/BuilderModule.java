package com.example.cartek.androidarchitecturecomponentstest.DI;

import com.example.cartek.androidarchitecturecomponentstest.UI.Input.CreateUser;
import com.example.cartek.androidarchitecturecomponentstest.UI.Input.CreateUserModule;
import com.example.cartek.androidarchitecturecomponentstest.UI.Main.MainActivity;
import com.example.cartek.androidarchitecturecomponentstest.UI.Main.MainActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by CarTek on 2018/2/22.
 */
@Module
public abstract class BuilderModule {
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = CreateUserModule.class)
    abstract CreateUser bindCreateUser();

}
