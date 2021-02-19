package com.alexthekap.androidretrofit2rxjava.retrofit;

import com.alexthekap.androidretrofit2rxjava.model.PostItem;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public interface JsonPlaceholderApi {

    @GET("posts")
    Observable<List<PostItem>> getPosts();
}
