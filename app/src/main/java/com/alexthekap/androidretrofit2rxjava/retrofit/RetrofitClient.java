package com.alexthekap.androidretrofit2rxjava.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getInstance() {
        if(ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
