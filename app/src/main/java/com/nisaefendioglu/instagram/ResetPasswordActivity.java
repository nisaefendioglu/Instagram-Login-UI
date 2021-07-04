package com.nisaefendioglu.instagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    ImageView resetImage;
    EditText resetUsername;
    Button newAccount, resetSendLogin , backToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword_layout);

        resetImage = (ImageView)findViewById(R.id.resetImage);
        resetUsername = (EditText)findViewById(R.id.resetUsername);
        newAccount = (Button)findViewById(R.id.newAccount);
        resetSendLogin = (Button)findViewById(R.id.resetSendLogin);
        backToLogin = (Button)findViewById(R.id.backToLogin);



        resetSendLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResetPasswordActivity.this, SignUpLayout.class));

            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));

            }
        });
    }

}
