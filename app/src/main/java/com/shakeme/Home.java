package com.shakeme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_btnShake,img_btnInfo, img_btnLocation,imgshake,img_logout;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        authListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null){
                    Intent loginIntent = new Intent(Home.this,Login.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                }
            }
        };


        img_btnShake = (ImageView) findViewById(R.id.img_btnShake);
        img_btnShake.setOnClickListener(this);
        img_btnInfo = (ImageView) findViewById(R.id.img_btnInfo);
        img_btnInfo.setOnClickListener(this);
        img_btnLocation = (ImageView) findViewById(R.id.img_btnLocation);
        img_btnLocation.setOnClickListener(this);
        img_logout = (ImageView) findViewById(R.id.btn_Logout);

        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
    }

    private void Logout() {
        auth.signOut();
    }

    @Override
    protected void onStart(){
        super.onStart();

        auth.addAuthStateListener(authListner);
    }

    @Override
    public void onClick(View v) {

        Fragment fragment;

        if(v == img_btnShake){
            fragment = new FragmentShake();
        }else if(v == img_btnLocation){
            fragment = new FragmentLocation();
        }else{
            fragment = new FragmentInfo();
        }

        ReplaceFragment(fragment);

    }



    public void ReplaceFragment(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.framelayout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
