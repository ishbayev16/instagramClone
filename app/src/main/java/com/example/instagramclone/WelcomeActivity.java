package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {

    private TextView txtWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcome = findViewById(R.id.txtWelcome);

        txtWelcome.setText("welcomeeeee "+ ParseUser.getCurrentUser().get("username"));

        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.getCurrentUser().logOut();
                finish();
                //activities are kept is stack if current activity is finished previous activity is loaded
                
            }
        });

    }
}
