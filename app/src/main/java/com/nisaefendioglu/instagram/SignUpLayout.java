package com.nisaefendioglu.instagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpLayout extends AppCompatActivity {

    EditText email, fullName, userName, userPassword;
    Button loginButtonFacebook, signUp, loginPageButton;
    ImageButton appStore, googlePlayStore;

    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        email = (EditText)findViewById(R.id.email);
        fullName = (EditText) findViewById(R.id.fullName);
        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);

        loginButtonFacebook = (Button)findViewById(R.id.loginButtonFacebook);
        signUp = (Button)findViewById(R.id.signUp);
        loginPageButton = (Button)findViewById(R.id.loginPageButton);

        appStore = (ImageButton)findViewById(R.id.appStore);
        googlePlayStore = (ImageButton)findViewById(R.id.googlePlayStore);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String fullname = fullName.getText().toString();
                String username = userName.getText().toString();
                String password = userPassword.getText().toString();

                userAdd(mail,fullname,username,password);


            }


            public void userAdd(final String mail, final String fullname, final String username, final String password){
                databaseReference.child("Users").child(username).child("UserName").child(mail).child("E-mail").child(fullname).child("FullName").child(password).child("Password").setValue(username).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull  Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(SignUpLayout.this, HomePageActivity.class);
                            intent.putExtra("UserName", username);
                            startActivity(intent);
                        }
                    }
                });


            }


        });
    }

    public void loginFacebookOnClick(View view) {

    }
    public void loginOnClick(View view) {
        Intent intent = new Intent(SignUpLayout.this, LoginActivity.class);
        startActivity(intent);
    }

    public void appStoreOnClick(View view) {
        Uri appStoreLink = Uri.parse("https://apps.apple.com/app/instagram/id389801252?vt=lo");
        Intent intent = new Intent(Intent.ACTION_VIEW, appStoreLink);
        startActivity(intent);
    }

    public void googlePlayStoreOnClick(View view) {
        Uri googlePlayStoreLink = Uri.parse("https://play.google.com/store/apps/details?id=com.instagram.android&referrer=utm_source%3Dinstagramweb&utm_campaign=loginPage&ig_mid=DB811887-EF92-4DEB-90EC-D7D119C500A7&utm_content=lo&utm_medium=badge");
        Intent intent = new Intent(Intent.ACTION_VIEW, googlePlayStoreLink);
        startActivity(intent);
    }
}
