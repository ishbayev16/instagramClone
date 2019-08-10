package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("U8H4sBOCCYYMjYpkdO2yDAYec1LQmIhvwP6dbKeK")
                // if defined
                .clientKey("jGkAvcAEE178mc7OFb1NOog6hewVpIAF2AIlmObB")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
