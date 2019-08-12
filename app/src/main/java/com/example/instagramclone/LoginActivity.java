package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLoginEmail, edtLoginPassword;
    private Button btnLoginActivity, btnSignUpLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);

        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnSignUpLoginActivity = findViewById(R.id.btnSignUpLoginActivity);

        btnLoginActivity.setOnClickListener(this);
        btnSignUpLoginActivity.setOnClickListener(this);

        if(ParseUser.getCurrentUser()!=null){
            ParseUser.getCurrentUser().logOut();
        }

    }//onCreate


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginActivity:

                if(edtLoginEmail.getText().toString().equals("") || edtLoginPassword.getText().toString().equals("")){
                    FancyToast.makeText(LoginActivity.this,  "empty values are not allowed",
                            Toast.LENGTH_SHORT, FancyToast.INFO, true).show();
                }else {
                    ParseUser.logInInBackground(edtLoginEmail.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if (user != null && e == null) {
                                FancyToast.makeText(LoginActivity.this, user.getUsername() + " is logged in",
                                        Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                                transitionToSocialMediaActivity();
                            } else {
                                FancyToast.makeText(LoginActivity.this, "error: " + e.getMessage(),
                                        Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                            }
                        }
                    });
                }

                break;
            case R.id.btnSignUpLoginActivity:

                 Intent intent = new Intent(LoginActivity.this, SignUp.class);
                 startActivity(intent);
                break;
        }
    }//onClick

    private void transitionToSocialMediaActivity(){
        Intent intent = new Intent(LoginActivity.this, SocialMediaActivity.class);
        startActivity(intent);
    }
}
