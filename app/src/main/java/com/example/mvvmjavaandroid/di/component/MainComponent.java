package com.example.mvvmjavaandroid.di.component;

import com.example.mvvmjavaandroid.di.modules.MainModule;
import com.example.mvvmjavaandroid.di.modules.RetrofitModule;
import com.example.mvvmjavaandroid.di.modules.RoomModule;
import com.example.mvvmjavaandroid.ui.activities.MainActivity;
import com.example.mvvmjavaandroid.ui.activities.RetrofitActivity;
import com.example.mvvmjavaandroid.ui.activities.RoomActivity;

import dagger.Component;

@Component(modules = {MainModule.class, RetrofitModule.class, RoomModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(RetrofitActivity retrofitActivity);

    void inject(RoomActivity roomActivity);
}
