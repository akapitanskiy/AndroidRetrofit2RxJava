package com.alexthekap.androidretrofit2rxjava.retrofit;

import android.database.Observable;

import com.alexthekap.androidretrofit2rxjava.model.PostItem;

import java.util.List;


import retrofit2.http.GET;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public interface IMyAPI {

    @GET("posts")
    Observable<List<PostItem>> getItems();

}
