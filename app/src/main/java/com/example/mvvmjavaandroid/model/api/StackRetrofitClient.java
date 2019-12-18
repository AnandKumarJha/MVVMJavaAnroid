package com.example.mvvmjavaandroid.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackRetrofitClient {

    private static Retrofit mRetrofit;
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static StackApi getStackRetrofitClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit.create(StackApi.class);
    }


}
