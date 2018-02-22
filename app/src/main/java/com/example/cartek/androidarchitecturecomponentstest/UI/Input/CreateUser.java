package com.example.cartek.androidarchitecturecomponentstest.UI.Input;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cartek.androidarchitecturecomponentstest.Data.AppDatabase;
import com.example.cartek.androidarchitecturecomponentstest.R;
import com.example.cartek.androidarchitecturecomponentstest.UI.Main.MainActivity;
import com.example.cartek.androidarchitecturecomponentstest.Data.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by CarTek on 2018/2/22.
 */

public class CreateUser extends DaggerAppCompatActivity {

    private static final String TAG = "CreateUser";

    @Inject
    AppDatabase db;

    @BindView(R.id.first_name)
    TextInputEditText firstName;
    @BindView(R.id.last_name)
    TextInputEditText lastName;
    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        ButterKnife.bind(this);

//        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
//                .allowMainThreadQueries()
//                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "onClick: firstName: " + firstName.getText().toString());
//            db.userDao().insertAll(new User("FirstName", "LastName", "TestEmail@gmail.com"));
                User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString());
                db.userDao().insertAll(user);
            startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
