package com.example.mvvmjavaandroid.model;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmjavaandroid.model.api.EmployeeDataService;
import com.example.mvvmjavaandroid.model.api.RetrofitClient;
import com.example.mvvmjavaandroid.model.api.pojo.Employee;
import com.example.mvvmjavaandroid.model.api.pojo.EmployeeDBResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String TAG = "EmployeeRepository";
    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<List<Employee>> mutableLiveData = new MutableLiveData<>();

    public EmployeeRepository() {
    }

    @SuppressLint("CheckResult")
    public MutableLiveData<List<Employee>> getMutableLiveData() {

        final EmployeeDataService userDataService = RetrofitClient.getService();

        //Call<EmployeeDBResponse> call = userDataService.getEmployees();
//        call.enqueue(new Callback<EmployeeDBResponse>() {
//            @Override
//            public void onResponse(Call<EmployeeDBResponse> call, Response<EmployeeDBResponse> response) {
//                EmployeeDBResponse employeeDBResponse = response.body();
//                if (employeeDBResponse != null && employeeDBResponse.getEmployee() != null) {
//                    employees = (ArrayList<Employee>) employeeDBResponse.getEmployee();
//                    mutableLiveData.setValue(employees);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<EmployeeDBResponse> call, Throwable t) {
//            }
//        });


        userDataService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<EmployeeDBResponse>() {
                    @Override
                    public void onSuccess(EmployeeDBResponse employeeDBResponse) {
                        if (employeeDBResponse != null && employeeDBResponse.getEmployee() != null) {
                            employees = (ArrayList<Employee>) employeeDBResponse.getEmployee();
                            mutableLiveData.setValue(employees);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                    }
                });

        return mutableLiveData;
    }
}