package com.example.mvvmjavaandroid.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.model.db.entity.Student;
import com.example.mvvmjavaandroid.viewmodel.StudentViewModel;
import com.example.mvvmjavaandroid.viewmodel.factory.StudentViewModelFactory;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private StudentViewModelFactory mStudentViewModelFactory;
    private StudentViewModel mStudentViewModel;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mStudentViewModelFactory = new StudentViewModelFactory(getApplication());
        mStudentViewModel = ViewModelProviders.of(this, mStudentViewModelFactory).get(StudentViewModel.class);

        mStudentViewModel.getStudentList().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                Log.e("TAG"+(count++), ""+students);
            }
        });

        mStudentViewModel.insertStudent();
        mStudentViewModel.insertStudent();
        mStudentViewModel.insertStudent();
    }
}
