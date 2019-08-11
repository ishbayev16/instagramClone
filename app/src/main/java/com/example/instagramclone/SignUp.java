package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class SignUp extends AppCompatActivity {

    TextView txtGetData;

    //some comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtGetData = findViewById(R.id.txtGetData);

        txtGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
//                parseQuery.getInBackground("bYG6s8J7bJ", new GetCallback<ParseObject>() {
//                    @Override
//                    public void done(ParseObject object, ParseException e) {
//
//                        String name = object.get("name")+"";
//
//                        if(object!=null && e==null){
//                            txtGetData.setText(object.get("name") + "");
//                        }
//                    }
//                });
                ParseQuery<ParseObject> queryall = ParseQuery.getQuery("KickBoxer");
                queryall.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e==null){
                            if(objects.size()>0){
                                txtGetData.setText(objects.size()+"");
                            }
                        }else{
                            Toast.makeText(SignUp.this,"error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

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
