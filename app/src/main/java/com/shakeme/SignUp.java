package com.shakeme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    private ImageView btnSignUP;
    private DatabaseReference mref;
    private EditText name,userName,email,password;

    private FirebaseAuth auth;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        progress = new ProgressDialog(this);

        mref = FirebaseDatabase.getInstance().getReference().child("Users");


        btnSignUP = (ImageView) findViewById(R.id.btn_SignUP);

        name = (EditText) findViewById(R.id.txt_FullName);
        userName = (EditText) findViewById(R.id.txt_UserNamesignup);
        email = (EditText) findViewById(R.id.txt_Email);
        password = (EditText) findViewById(R.id.txt_Password);

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StratRegister();
            }
        });

    }

    private void StratRegister() {
        final String fullname = name.getText().toString();
        final String usernamefield = userName.getText().toString().trim();
        final String emailfield = email.getText().toString().trim();
        final String passwordfield = password.getText().toString().trim();

        boolean isTrue = true;

        if(TextUtils.isEmpty(fullname)){
            name.setError("Full Name is Required");
            isTrue = false;
        }

        if(TextUtils.isEmpty(usernamefield)){
            userName.setError("UserName is Required");
            isTrue = false;
        }

        if(TextUtils.isEmpty(emailfield)){
            email.setError("Email is Required");
            isTrue = false;
        }

        if(TextUtils.isEmpty(password.getText())){
            password.setError("Password is Required");
            isTrue = false;
        }

        if(!TextUtils.isEmpty(password.getText()) && password.getText().length() < 6){
            password.setError("Password must be at least 6 characters");
        }

        if(isTrue){

            progress.setMessage("Signing Up........");

            auth.createUserWithEmailAndPassword(emailfield,passwordfield).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        String user_ID = auth.getCurrentUser().getUid();

                        DatabaseReference current_userdb = mref.child(user_ID);

                        current_userdb.child("Name").setValue(fullname);
                        current_userdb.child("UserName").setValue(usernamefield);
                        //current_userdb.child("Email").setValue(emailfield);
                        //current_userdb.child("Password").setValue(passwordfield);

                        progress.dismiss();

                        Intent mainIntent = new Intent(SignUp.this, Home.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntent);
                    }
                }
            });

        }
    }
}
