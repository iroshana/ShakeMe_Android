package com.shakeme;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
                        //Fragment fragment = new FragmentOffer();

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        ReplaceFragment();
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
                        //Fragment fragment = new FragmentOffer();

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        ReplaceFragment();
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
                        //Fragment fragment = new FragmentOffer();

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        ReplaceFragment();
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
                        //Fragment fragment = new FragmentOffer();

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        ReplaceFragment();
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
                        //Fragment fragment = new FragmentOffer();

                        ref = FirebaseDatabase.getInstance().getReference().child("Users");
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = ref.child(user_ID);
                        current_userdb.child("OfferKey").setValue(categoryVM.getKey());
                        current_userdb.child("OfferName").setValue(categoryVM.getName());

                        ReplaceFragment();
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


    public void ReplaceFragment(){
        /*final FragmentManager manager = getFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.framelayout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();*/

        Intent mainIntent = new Intent(getActivity(),Offer.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(mainIntent, 0);
        //startActivity(mainIntent);
    }
}
