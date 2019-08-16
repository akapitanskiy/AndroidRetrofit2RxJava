package com.alexthekap.androidretrofit2rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alexthekap.androidretrofit2rxjava.Adapter.PostAdapter;
import com.alexthekap.androidretrofit2rxjava.model.PostItem;
import com.alexthekap.androidretrofit2rxjava.retrofit.IMyAPI;
import com.alexthekap.androidretrofit2rxjava.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IMyAPI myAPI;
    RecyclerView recycler_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IMyAPI.class);

        recycler_posts = findViewById(R.id.recycler_posts);
        recycler_posts.setHasFixedSize(true);
        recycler_posts.setLayoutManager(new LinearLayoutManager(this));

        fetchdata();
    }

    private void fetchdata() {
        compositeDisposable.add(myAPI.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PostItem>>() {
                    @Override
                    public void accept(List<PostItem> postItems) throws Exception {
                        displayData(postItems);
                    }
                })
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
