package com.shakeme;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Model.Category;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tharindu on 4/4/2017.
 */

public class Fragment_Selection extends Fragment implements View.OnClickListener {

    private ImageView burger,pizza,chicken,drinks,meal;
    private DatabaseReference ref;
    private FirebaseAuth auth;
    private List<Category> lstCategory = new ArrayList<>();

    private TextView offer;
    private Button redeem;

    private TextView txt8,txt6,txt11,txt9,txt10;

    //private Category categoryVM;
    //private Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.selection_layout,container,false);

        ref = FirebaseDatabase.getInstance().getReference().child("Category");
        auth = FirebaseAuth.getInstance();



        drinks = (ImageView) view.findViewById(R.id.img_btn_drinks);
        //drinks.setOnClickListener(this);
        pizza = (ImageView) view.findViewById(R.id.img_btn_pizza);
        //pizza.setOnClickListener(this);
        burger = (ImageView) view.findViewById(R.id.img_btn_burgers);
        //burger.setOnClickListener(this);
        chicken = (ImageView) view.findViewById(R.id.img_btn_chiken);
        //chicken.setOnClickListener(this);
        meal = (ImageView) view.findViewById(R.id.img_btn_meal);
        //meal.setOnClickListener(this);
        offer = (TextView) view.findViewById(R.id.txt_Offer);
        redeem = (Button) view.findViewById(R.id.btn_Redeeem);


        txt6 = (TextView) view.findViewById(R.id.textView6);
        txt8 = (TextView) view.findViewById(R.id.textView8);
        txt9 = (TextView) view.findViewById(R.id.textView9);
        txt10 = (TextView) view.findViewById(R.id.textView10);
        txt11 = (TextView) view.findViewById(R.id.textView11);

        redeem.setVisibility(View.INVISIBLE);

        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Home.class));

            }
        });

        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Category").child("Meal");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lstCategory.clear();
                        for (DataSnapshot sanp : dataSnapshot.getChildren()){
                            Category dr = sanp.getValue(Category.class);
                            lstCategory.add(dr);
                        }

                        Category categoryVM = lstCategory.get(new Random().nextInt(lstCategory.size()));
                        Log.d("------ "+categoryVM.getName(), categoryVM.getKey());

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        offer.setText(categoryVM.getName() + " - " + categoryVM.getKey());
                        redeem.setVisibility(View.VISIBLE);

                        Hide();
                        setRetainInstance(false);
                        //startActivity(new Intent(getActivity(),Offer.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Category").child("Chicken");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lstCategory.clear();
                        for (DataSnapshot sanp : dataSnapshot.getChildren()){
                            Category dr = sanp.getValue(Category.class);
                            lstCategory.add(dr);
                        }

                        Category categoryVM = lstCategory.get(new Random().nextInt(lstCategory.size()));
                        Log.d("------ "+categoryVM.getName(), categoryVM.getKey());

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        offer.setText(categoryVM.getName() + " - " + categoryVM.getKey());
                        redeem.setVisibility(View.VISIBLE);

                        Hide();
                        //startActivity(new Intent(getActivity(),Offer.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Category").child("Burger");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lstCategory.clear();
                        for (DataSnapshot sanp : dataSnapshot.getChildren()){
                            Category dr = sanp.getValue(Category.class);
                            lstCategory.add(dr);
                        }

                        Category categoryVM = lstCategory.get(new Random().nextInt(lstCategory.size()));
                        Log.d("------ "+categoryVM.getName(), categoryVM.getKey());

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        offer.setText(categoryVM.getName() + " - " + categoryVM.getKey());
                        redeem.setVisibility(View.VISIBLE);

                        Hide();
                        //startActivity(new Intent(getActivity(),Offer.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Category").child("Drinks");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lstCategory.clear();
                        for (DataSnapshot sanp : dataSnapshot.getChildren()){
                            Category dr = sanp.getValue(Category.class);
                            lstCategory.add(dr);
                        }

                        Category categoryVM = lstCategory.get(new Random().nextInt(lstCategory.size()));
                        Log.d("------ "+categoryVM.getName(), categoryVM.getKey());

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        offer.setText(categoryVM.getName() + " - " + categoryVM.getKey());
                        redeem.setVisibility(View.VISIBLE);

                        Hide();
                        //startActivity(new Intent(getActivity(),Offer.class));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Category").child("Pizza");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lstCategory.clear();
                        for (DataSnapshot sanp : dataSnapshot.getChildren()){
                            Category dr = sanp.getValue(Category.class);
                            lstCategory.add(dr);
                        }

                        Category categoryVM = lstCategory.get(new Random().nextInt(lstCategory.size()));
                        Log.d("------ "+categoryVM.getName(), categoryVM.getKey());

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        offer.setText(categoryVM.getName() + " - " + categoryVM.getKey());
                        redeem.setVisibility(View.VISIBLE);
                        Hide();
                        //startActivity(new Intent(getActivity(),Offer.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }

    private void Hide(){
        meal.setVisibility(View.GONE);
        drinks.setVisibility(View.GONE);
        pizza.setVisibility(View.GONE);
        burger.setVisibility(View.GONE);
        chicken.setVisibility(View.GONE);

        txt6.setVisibility(View.GONE);
        txt8.setVisibility(View.GONE);
        txt9.setVisibility(View.GONE);
        txt10.setVisibility(View.GONE);
        txt11.setVisibility(View.GONE);
    }

}
