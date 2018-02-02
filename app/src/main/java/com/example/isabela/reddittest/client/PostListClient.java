package com.example.isabela.reddittest.client;

import com.example.isabela.reddittest.client.service.RedditAndroidService;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.model.CommentListing;

import java.util.List;

import io.reactivex.Observable;

public class PostListClient {

    private final RedditAndroidService service;

    public PostListClient(RedditAndroidService service) {
        this.service = service;
    }

    public Observable<PostListing> getListPost() {

        return service.listPosts();
    }

    public Observable<List<CommentListing>> getListComments(String postId) {

        return service.listComments(postId);
    }

    public Observable<PostListing> getNextPagePostList(String afterId) {

        return service.getNextPage(afterId);
    }

//    private RedditAndroidService createRedditAndroidService() {
//        Retrofit retrofit = new RetrofitFactory().build();
//
//        return retrofit.create(RedditAndroidService.class);
//    }
}
