package com.example.mvvmjavaandroid.viewmodel.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmjavaandroid.viewmodel.StudentViewModel;

public class StudentViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    public StudentViewModelFactory(Application application){
        mApplication = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(StudentViewModel.class)){
            return (T) new StudentViewModel(mApplication);
        }
        return null;
    }
}
