package com.example.clever_tap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class Loginpage extends AppCompatActivity {
    EditText username , emailid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
    }

    // LOGIN BTN
    public void Loginbtn(View view) {
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);

        username = findViewById(R.id.username);
        emailid = findViewById(R.id.Emailid);

        String Username_ = username.getText().toString();
        String Email_ = emailid.getText().toString();

        //validation
        if (!Username_.isEmpty()) //for username
        {
            username.setError(null);

            if (!Email_.isEmpty()) // for email
            {
                emailid.setError(null);

                //main coding area

                // OnUserLogin  function
                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Name",username);
                profileUpdate.put("Email Address",emailid);
                clevertapDefaultInstance.onUserLogin(profileUpdate);

                //profile push function
                HashMap<String, Object> ProfilePush = new HashMap<String, Object>();
                ProfilePush.put("Name",username);
                ProfilePush.put("Email Address",emailid);
                clevertapDefaultInstance.pushProfile(ProfilePush);

                //Event
                clevertapDefaultInstance.pushEvent("Product Viewed");

                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

            }
            else //for username
            {
                emailid.setError("Enter the Email Address");
            }
        }else   // for email
        {   username.setError("Enter the Username");

        }


    }

    public void testpage(View view) {
        Intent intent = new Intent(getApplicationContext(), Eventpage.class);
        startActivity(intent);
    }
}