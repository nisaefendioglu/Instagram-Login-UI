package com.nisaefendioglu.instagram;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText userName;
    EditText userPassword;
    TextView errorMessage;
    Button loginButton;
    Button loginButtonFacebook;
    Button forgetPassword;
    Button signUp;
    ImageView instagramLogo;


    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        userName = (EditText)findViewById(R.id.userName);
        userPassword = (EditText)findViewById(R.id.userPassword);
        errorMessage = (TextView)findViewById(R.id.errorMessage);
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButtonFacebook = (Button) findViewById(R.id.loginButtonFacebook);
        forgetPassword = (Button) findViewById(R.id.forgetPassword);
        signUp = (Button) findViewById(R.id.signUp);
        instagramLogo = (ImageView)findViewById(R.id.instagramLogo);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String password = userPassword.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                        }
                        else {
                            errorMessage.setText("Sorry, the username or password is incorrect.");
                            Log.e("name or password err", task.getException().getMessage());

                        }
                    }
                });

            }
        });

    }



    public void loginFacebookOnClick(View view) {
    }

    public void forgetPasswordOnClick(View view) {
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    public void signUpOnClick(View view) {
        Intent intent = new Intent(this, SignUpLayout.class);
        startActivity(intent);
    }
}
