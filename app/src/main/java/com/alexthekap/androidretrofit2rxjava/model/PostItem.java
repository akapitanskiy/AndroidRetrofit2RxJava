package com.alexthekap.androidretrofit2rxjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by a.kapitanskiy
 * on 15.08.2019
 */
public class PostItem {

    @SerializedName("userId") @Expose
    private int userId;

    @SerializedName("id") @Expose
    private int id;

    @SerializedName("title") @Expose
    private String title;

    @SerializedName("body") @Expose
    private String body;

    public PostItem() {
    }

    public PostItem(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
