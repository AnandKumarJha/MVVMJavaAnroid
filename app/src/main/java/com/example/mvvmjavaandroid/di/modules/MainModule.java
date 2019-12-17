package com.example.mvvmjavaandroid.di.modules;

import com.example.mvvmjavaandroid.viewmodel.factory.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private static final int SOME_DUMMY_DATA = 5;

    //Viewmodel factory is being used for some dummy data just for example purpose
    @Provides
    public ViewModelFactory getViewModelFactory(){
        return new ViewModelFactory(SOME_DUMMY_DATA);
    }
}
