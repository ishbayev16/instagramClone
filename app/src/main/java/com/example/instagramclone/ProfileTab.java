package com.example.instagramclone;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileTab extends Fragment {

    private EditText edtProfileName, edtProfileBio, edtProfileProfession, edtProfileHobbies, edtProfileFavoriteSport;

    private Button btnUpdateInfo;


    public ProfileTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);

        edtProfileName = view.findViewById(R.id.edtProfileName);
        edtProfileBio = view.findViewById(R.id.edtProfileBio);
        edtProfileProfession = view.findViewById(R.id.edtProfileProfession);
        edtProfileHobbies = view.findViewById(R.id.edtProfileHobbies);
        edtProfileFavoriteSport = view.findViewById(R.id.edtProfileFavoriteSport);

        btnUpdateInfo = view.findViewById(R.id.btnUpdateInfo);

        final ParseUser parseUser = ParseUser.getCurrentUser();


        if(parseUser.get("profileName")==null){
            edtProfileName.setText("");
        }else{
            edtProfileName.setText(parseUser.get("profileName").toString());
        }

//        edtProfileName.setText(parseUser.get("profileName")+"");
        edtProfileBio.setText(parseUser.get("profileBio")+"");
        edtProfileProfession.setText(parseUser.get("profileProfession")+"");
        edtProfileHobbies.setText(parseUser.get("profileHobbies")+"");
        edtProfileFavoriteSport.setText(parseUser.get("profileFavoriteSport")+"");


        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parseUser.put("profileName", edtProfileName.getText().toString());
                parseUser.put("profileBio", edtProfileBio.getText().toString());
                parseUser.put("profileProfession",edtProfileProfession.getText().toString());
                parseUser.put("profileHobbies",edtProfileHobbies.getText().toString());
                parseUser.put("profileFavoriteSport",edtProfileFavoriteSport.getText().toString());


                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("updating Profile info of" + parseUser.getUsername());
                progressDialog.show();

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(getContext(), "info Updated", Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                        }else{
                            FancyToast.makeText(getContext(), "error: "+ e.getMessage(), Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                        }

                        progressDialog.dismiss();
                    }
                });


            }
        });


        return view;

    }


}
