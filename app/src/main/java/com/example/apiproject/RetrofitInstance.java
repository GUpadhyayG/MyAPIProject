package com.example.apiproject;

import static com.example.apiproject.ThirdActivity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    static RetrofitInstance instance;
    ApiInterface apiInterface;

   public  RetrofitInstance()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       apiInterface = retrofit.create(ApiInterface.class);

    }

    public static RetrofitInstance getInstance()
    {
        if(instance==null) {
            instance = new RetrofitInstance();

        }
            return instance;

    }
}
