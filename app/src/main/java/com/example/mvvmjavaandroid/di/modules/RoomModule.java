package com.example.mvvmjavaandroid.di.modules;

import android.app.Application;

import com.example.mvvmjavaandroid.viewmodel.factory.StudentViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    Application mApplication;
    public RoomModule(Application application){
        mApplication = application;
    }

    @Provides
    public StudentViewModelFactory getStudentViewModelFactory(){
        return new StudentViewModelFactory(mApplication);
    }

}
