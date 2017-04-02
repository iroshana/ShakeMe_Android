package com.shakeme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ravindu on 4/2/2017.
 */

public class FragmentShake extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inaInflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inaInflater.inflate(R.layout.shake_layout, container, false);
    }
}
