package com.example.mvvmjavaandroid.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://reqres.in/api/";

    public static EmployeeDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //rx java specific call
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(EmployeeDataService.class);
    }
}