package com.example.mvvmjavaandroid.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmjavaandroid.viewmodel.MainViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    int mSumDummyData;

    public ViewModelFactory(int sumDummyData){
        mSumDummyData = sumDummyData;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mSumDummyData);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
