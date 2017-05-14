package com.shakeme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Offer extends AppCompatActivity {

    private DatabaseReference ref;
    private FirebaseAuth auth;

    private TextView txtOffer;
    private User user = new User();

    private List<User> lstUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("Users");

        final String user_ID = auth.getCurrentUser().getUid();

        DatabaseReference current_userdb = ref.child(user_ID);



        current_userdb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
