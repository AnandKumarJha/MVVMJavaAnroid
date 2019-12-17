package com.example.mvvmjavaandroid.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.example.mvvmjavaandroid.MyApplication;
import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.databinding.ActivityMainBinding;
import com.example.mvvmjavaandroid.viewmodel.MainViewModel;
import com.example.mvvmjavaandroid.viewmodel.factory.ViewModelFactory;

import javax.inject.Inject;

//MVVM(done)
//View Model with factory(done)
//Live Data(done)
//Room(done)
//room update database schema(done)
//insert data initially

//work manager(done)

//Recycler view swipe and adapter
//dialog with match parent

//with fragment viewmodel and data binding and dialog
//view model factory with data binding

//retrofit (Retrofit activity)(done)
//data binding(done)
//glide(done)

//dagger(working)

//test cases for kotlin
//test cases for rx java

//diff Util
//paging

//kotlin
//Coroutine
//By only retrofit(done)
//By Co routine
//By Rx(done)

public class MainActivity extends AppCompatActivity {

    private MainViewModel mMainViewModel;
    private ActivityMainBinding activityMainBinding;
    @Inject
    ViewModelFactory mViewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication)getApplication()).getMainComponent().inject(this);
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

        mMainViewModel.workManagerClicked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                startActivity(new Intent(MainActivity.this, WorkManagerActivity.class));
            }
        });
    }
}
