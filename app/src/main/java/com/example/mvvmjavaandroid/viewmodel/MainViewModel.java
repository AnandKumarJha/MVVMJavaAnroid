package com.example.mvvmjavaandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int mSumDummyData;
    public MutableLiveData<Boolean> retrofitButtonClicked = new MutableLiveData<>();
    public MutableLiveData<Boolean> roomButtonClicked = new MutableLiveData<>();

    public MainViewModel(int mSumDummyData) {
        this.mSumDummyData = mSumDummyData;
    }

    public void retrofitButtonClicked() {
        Log.e("TAG", "Value Recived : " + mSumDummyData);
        retrofitButtonClicked.setValue(true);
    }

    public void roomButtonClicked() {
        Log.e("TAG", "Value Recived : " + mSumDummyData);
        roomButtonClicked.setValue(true);
    }
}
