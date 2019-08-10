package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void helloWorldTapped(View view){

//        ParseObject boxer = new ParseObject("Boxer");
//
//        boxer.put("punch_speed",200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    Toast.makeText(SignUp.this,"Boxer object is saved successfully", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });

        final ParseObject kickBoxer = new ParseObject("KickBoxer");
        kickBoxer.put("name","john");
        kickBoxer.put("punch_speed",200);
        kickBoxer.put("punch_power",100);
        kickBoxer.put("kick_speed",300);
        kickBoxer.put("kick_power",500);

        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    FancyToast.makeText(SignUp.this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show();

//                    Toast.makeText(SignUp.this, kickBoxer.get("name")+ " is saved to server", Toast.LENGTH_LONG).show();
                }
            }
        });

    }//helloWorldTapped

}
