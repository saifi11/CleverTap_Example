package com.example.clever_tap;

import android.app.Application;

import com.clevertap.android.sdk.ActivityLifecycleCallback;

public class Applicationclass extends Application {
    public void onCreate() {

        ActivityLifecycleCallback.register(this);
        super.onCreate();
    }
}
