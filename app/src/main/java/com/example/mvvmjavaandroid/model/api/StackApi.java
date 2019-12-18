package com.example.mvvmjavaandroid.model.api;

import com.example.mvvmjavaandroid.model.api.pojo.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackApi {

    //url from where the data needs to be driven
    //https://api.stackexchange.com/2.2/answers?page=1&pagesize=50&site=stackoverflow

    //base url
    //https://api.stackexchange.com/2.2/

    //get annotation
    //answers

    @GET("answers")
    Call<StackApiResponse> getAnswers(@Query("page") int page, @Query("pagesize") int pageSize, @Query("site") String site);
}
