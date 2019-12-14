package com.example.mvvmjavaandroid.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmjavaandroid.model.EmployeeRepository;
import com.example.mvvmjavaandroid.model.api.pojo.Employee;

public class EmployeeViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }

    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}