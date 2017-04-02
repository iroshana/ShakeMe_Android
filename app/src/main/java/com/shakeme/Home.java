package com.shakeme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_btnShake,img_btnInfo, img_btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img_btnShake = (ImageView) findViewById(R.id.img_btnShake);
        img_btnShake.setOnClickListener(this);
        img_btnInfo = (ImageView) findViewById(R.id.img_btnInfo);
        img_btnInfo.setOnClickListener(this);
        img_btnLocation = (ImageView) findViewById(R.id.img_btnLocation);
        img_btnLocation.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {

        Fragment fragment;

        if(v == img_btnShake){
            fragment = new FragmentShake();
        }else {
            fragment = new FragmentLocation();
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
