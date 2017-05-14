package com.shakeme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Ravindu on 5/12/2017.
 */

public class FragmentOffer extends Fragment{

    private DatabaseReference ref;
    private FirebaseAuth auth;

    private TextView txtOffer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //auth = FirebaseAuth.getInstance();
        //ref = FirebaseDatabase.getInstance().getReference().child("Users");
        //String user_ID = auth.getCurrentUser().getUid();

        //DatabaseReference current_userdb = ref.child(user_ID);

        View viewa = inflater.inflate(R.layout.offer_layout,container,false);

        txtOffer = (TextView) viewa.findViewById(R.id.txt_OfferCode);
        txtOffer.setText("Hello World");

        return viewa;
    }

}
