package com.example.mvvmjavaandroid.di.modules;

import com.example.mvvmjavaandroid.ui.adapter.EmployeeDataAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {

    @Provides
    public EmployeeDataAdapter getEmployeeAdapter(){
        return new EmployeeDataAdapter();
    }

}
