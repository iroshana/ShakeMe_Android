package com.shakeme;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Ravindu on 4/30/2017.
 */

public class Firebase extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
