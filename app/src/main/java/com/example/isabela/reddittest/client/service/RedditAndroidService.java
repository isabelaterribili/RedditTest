package com.example.isabela.reddittest.client.service;

import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.model.CommentListing;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditAndroidService {
    @GET("r/Android/new/.json")
    Observable<PostListing> listPosts();

    @GET("r/Android/new/.json")
    Observable<PostListing> getNextPage(@Query("after") String afterId);

    @GET("r/Android/comments/{id}/.json")
    Observable<List<CommentListing>> listComments(@Path("id") String id);

}
