package com.shakeme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ravindu on 4/2/2017.
 */

public class FragmentShake extends Fragment implements View.OnClickListener {

    private ImageView imgshakeLogo;
    private ImageView img_btnShake,img_btnInfo, img_btnLocation;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    @Override
    public View onCreateView(LayoutInflater inaInflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inaInflater.inflate(R.layout.shake_layout, container, false);


        imgshakeLogo = (ImageView) view.findViewById(R.id.img_shake_btnLogo);
        imgshakeLogo.setOnClickListener(this);
        img_btnShake = (ImageView) view.findViewById(R.id.img_btnShake);
        img_btnInfo = (ImageView) view.findViewById(R.id.img_btnInfo);
        img_btnLocation = (ImageView) view.findViewById(R.id.img_btnLocation);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_shake_btnLogo :
                imgshakeLogo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SequenceScreen();
                    }
                });

        }
    }

    private void SequenceScreen() {
        Fragment fragment = new Fragment_Selection();
        //img_btnShake.setVisibility(View.GONE);
        //img_btnLocation.setVisibility(View.INVISIBLE);
        //img_btnInfo.setVisibility(View.INVISIBLE);

        ReplaceFragment(fragment);

    }

    private void ReplaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.framelayout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
