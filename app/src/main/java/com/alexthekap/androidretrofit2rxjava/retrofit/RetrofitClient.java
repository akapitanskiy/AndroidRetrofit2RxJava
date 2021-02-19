package com.alexthekap.androidretrofit2rxjava.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.alexthekap.androidretrofit2rxjava.utils.AppConstants;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public class RetrofitClient {

    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null)
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new Retrofit.Builder()
                            .baseUrl(AppConstants.jsonPlaceholderBaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        return instance;
    }

    private RetrofitClient() {
    }
}
