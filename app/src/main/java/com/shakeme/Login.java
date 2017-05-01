package com.shakeme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgLoginBtn;
    private TextView signUp;
    private EditText email,password;

    private FirebaseAuth auth;
    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        dbReference = FirebaseDatabase.getInstance().getReference().child("Users");

        imgLoginBtn = (ImageView) findViewById(R.id.img_LoginBtn);
        imgLoginBtn.setOnClickListener(this);
        signUp = (TextView) findViewById(R.id.signup);
        signUp.setOnClickListener(this);

        email = (EditText) findViewById(R.id.txt_Username_Login);
        password = (EditText) findViewById(R.id.txt_Password_Login);


    }


    @Override
    public void onClick(View v) {
        if(v==imgLoginBtn){
            imgLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckLogin();
                }
            });
        }else if(v == signUp){
            startActivity(new Intent(getApplicationContext(),
                    SignUp.class));
        }
    }

    private void CheckLogin() {
        String emailField = email.getText().toString().trim();
        String passwordField = password.getText().toString().trim();

        boolean isValid = true;

        if(TextUtils.isEmpty(emailField)){
            email.setError("Email is Required");
            isValid = false;
        }

        if(TextUtils.isEmpty(passwordField)){
            password.setError("Password is Reqiured");
            isValid = false;
        }

        if(isValid){
            auth.signInWithEmailAndPassword(emailField, passwordField).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        CheckUserExsist();

                    }else {
                        Toast.makeText(Login.this,"Error Login", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }

    private void CheckUserExsist() {
        final String user_ID = auth.getCurrentUser().getUid();

        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_ID)){
                    Intent mainIntent = new Intent(Login.this,Home.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);

                }else {
                    Toast.makeText(Login.this,"You need to Signup", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
