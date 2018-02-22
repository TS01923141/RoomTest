package com.example.tyc.roomtest.DI;

import com.example.tyc.roomtest.UI.Input.CreateUser;
import com.example.tyc.roomtest.UI.Input.CreateUserModule;
import com.example.tyc.roomtest.UI.Main.MainActivity;
import com.example.tyc.roomtest.UI.Main.MainActivityModule;

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
