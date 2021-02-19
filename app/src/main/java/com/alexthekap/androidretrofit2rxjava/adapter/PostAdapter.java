package com.alexthekap.androidretrofit2rxjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexthekap.androidretrofit2rxjava.R;
import com.alexthekap.androidretrofit2rxjava.model.PostItem;

import java.util.List;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<PostItem> postItems;

    public PostAdapter(Context context, List<PostItem> postsList) {
        this.context = context;
        this.postItems = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tvAuthor.setText(String.valueOf(postItems.get(position).getUserId()));
        holder.tvTitle.setText(String.valueOf(postItems.get(position).getTitle()));
        holder.tvContent.setText(String.format(context.getResources().getString(R.string.dots),
                postItems.get(position).getBody().substring(0, 30)));
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
