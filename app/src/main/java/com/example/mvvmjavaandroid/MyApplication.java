package com.example.mvvmjavaandroid;

import android.app.Application;

import com.example.mvvmjavaandroid.di.component.DaggerMainComponent;
import com.example.mvvmjavaandroid.di.component.MainComponent;
import com.example.mvvmjavaandroid.di.modules.MainModule;
import com.example.mvvmjavaandroid.di.modules.RetrofitModule;
import com.example.mvvmjavaandroid.di.modules.RoomModule;

public class MyApplication extends Application {

    MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).roomModule(new RoomModule(this)).retrofitModule(new RetrofitModule()).build();
    }

    public MainComponent getMainComponent(){
        return mainComponent;
    }
}
