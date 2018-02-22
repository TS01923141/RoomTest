package com.example.tyc.roomtest.UI.Main;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.tyc.roomtest.Data.AppDatabase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CarTek on 2018/2/22.
 */
@Module
public class MainActivityModule {

//    @Singleton
//    @Provides
//    static RecyclerView.Adapter provideAdapter(AppDatabase db){
//        List<User> users = db.userDao().getAllUsers();
//        return new UserAdapter(users);
//    }

//    @Singleton
    @Provides
    static AppDatabase provideAppDatabase(Context context) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        return db;
    }
}
