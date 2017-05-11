package com.shakeme;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Tharindu on 4/4/2017.
 */

public class Fragment_Selection extends Fragment implements View.OnClickListener {

    private ImageView burger,pizza,chicken,drinks,meal;
    private DatabaseReference ref;
    private ArrayList<HashMap<String,String>> lst = new ArrayList<HashMap<String, String>>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.selection_layout,container,false);

        ref = FirebaseDatabase.getInstance().getReference().child("Category");

        drinks = (ImageView) view.findViewById(R.id.img_btn_drinks);
        drinks.setOnClickListener(this);
        pizza = (ImageView) view.findViewById(R.id.img_btn_pizza);
        pizza.setOnClickListener(this);
        burger = (ImageView) view.findViewById(R.id.img_btn_burgers);
        burger.setOnClickListener(this);
        chicken = (ImageView) view.findViewById(R.id.img_btn_chiken);
        chicken.setOnClickListener(this);
        meal = (ImageView) view.findViewById(R.id.img_btn_meal);
        meal.setOnClickListener(this);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String val = dataSnapshot.child("Drinks").getValue(String.class);

                ArrayList<String> drink = new ArrayList<String>();
                drink.add(val);

                HashMap<String,String> map;

                for (String dri : drink) {
                    map = new HashMap<String, String>();

                    map.put("Name", dataSnapshot.child("Drinks").child(dri).child("Name").getValue(String.class));
                    map.put("Key", dataSnapshot.child("Drinks").child(dri).child("Key").getValue(String.class));

                    lst.add(map);
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_drinks:
                drinks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Drinks();
                    }
                });
                break;
        }

    }

    private void Drinks() {
        Random ran = new Random();

        lst.size();
    }
}
