package com.alexthekap.androidretrofit2rxjava.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexthekap.androidretrofit2rxjava.R;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle;
    TextView tvContent;
    TextView tvAuthor;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
        tvAuthor = itemView.findViewById(R.id.tvAuthor);
    }
}
