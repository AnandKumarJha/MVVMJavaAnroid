package com.example.mvvmjavaandroid.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.databinding.ActivityMainBinding;
import com.example.mvvmjavaandroid.viewmodel.MainViewModel;
import com.example.mvvmjavaandroid.viewmodel.factory.ViewModelFactory;

//MVVM(done)
//View Model with factory(done)
//Live Data(done)
//Room(done)
//room update database schema
//insert data initially

//Recycler view swipe and adapter
//dialog with match parent

//with fragment viewmodel and data binding and dialog
//view model factory with data binding

//retrofit (Retrofit activity)
//data binding
//glide

//dagger
//rx

//test cases for kotlin
//test cases for rx java

//kotlin
//Coroutine
//By only retrofit
//By Co routine
//By Rx

public class MainActivity extends AppCompatActivity {

    private MainViewModel mMainViewModel;
    private ActivityMainBinding activityMainBinding;
    private ViewModelFactory mViewModelFactory;
    private static final int SOME_DUMMY_DATA = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Viewmodel factory is being used for some dummy data just for example purpose
        mViewModelFactory = new ViewModelFactory(SOME_DUMMY_DATA);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        activityMainBinding.setMainViewModel(mMainViewModel);

        mMainViewModel.retrofitButtonClicked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
            }
        });

        mMainViewModel.roomButtonClicked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });
    }
}
