package com.example.tyc.roomtest.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tyc.roomtest.Data.AppDatabase;
import com.example.tyc.roomtest.UI.Input.CreateUser;
import com.example.tyc.roomtest.R;
import com.example.tyc.roomtest.Data.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    AppDatabase db;
//    @Inject
//    RecyclerView.Adapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @BindView(R.id.fab)
    FloatingActionButton fab;
//    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        users = new ArrayList<>();
//
//        for(int i = 0; i<10; i ++){
////            users.add("TestData # " + i);
//            User user = new User("FirstName #" + i, "LastName", "TestEmail@gmial.com");
//            users.add(user);
//        }

//        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
//                .allowMainThreadQueries()
//                .build();

        List<User> users = db.userDao().getAllUsers();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: pressed!");
                startActivity(new Intent(MainActivity.this, CreateUser.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
