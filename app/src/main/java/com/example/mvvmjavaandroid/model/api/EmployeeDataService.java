package com.example.mvvmjavaandroid.model.api;

import com.example.mvvmjavaandroid.model.api.pojo.EmployeeDBResponse;

import java.util.Observable;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataService {
//    @GET("users/?per_page=12&amp;page=1")
//    Call<EmployeeDBResponse> getEmployees();

    //For Rx
    @GET("users/?per_page=12&amp;page=1")
    Single<EmployeeDBResponse> getEmployees();
}