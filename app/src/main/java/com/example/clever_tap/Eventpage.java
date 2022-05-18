package com.example.clever_tap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.clevertap.android.sdk.CleverTapAPI;

public class Eventpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    // Event Click Button
    public void testbtn(View view) {

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        clevertapDefaultInstance.pushEvent("TEST");
        Toast.makeText(getApplicationContext(), "TEST EVENT", Toast.LENGTH_SHORT).show();
    }
}