package com.alexthekap.androidretrofit2rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alexthekap.androidretrofit2rxjava.adapter.PostAdapter;
import com.alexthekap.androidretrofit2rxjava.model.PostItem;
import com.alexthekap.androidretrofit2rxjava.retrofit.JsonPlaceholderApi;
import com.alexthekap.androidretrofit2rxjava.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    JsonPlaceholderApi jsonPlaceholderApi;
    RecyclerView recycler_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        recycler_posts = findViewById(R.id.recycler_posts);
        recycler_posts.setHasFixedSize(true);
        recycler_posts.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(jsonPlaceholderApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayData)
            );
    }

    private void displayData(List<PostItem> postItems) {
        PostAdapter adapter = new PostAdapter(this, postItems);
        recycler_posts.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
