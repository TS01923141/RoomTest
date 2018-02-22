package com.example.cartek.androidarchitecturecomponentstest.UI.Input;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.cartek.androidarchitecturecomponentstest.Data.AppDatabase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CarTek on 2018/2/22.
 */
@Module
public abstract class CreateUserModule {
    @Provides
    static AppDatabase provideAppDatabase(Context context) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        return db;
    }
}
