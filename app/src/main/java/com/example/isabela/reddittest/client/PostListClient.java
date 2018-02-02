package com.example.isabela.reddittest.client;

import com.example.isabela.reddittest.client.service.RedditAndroidService;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.model.CommentListing;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class PostListClient {

    public Observable<PostListing> getListPost() {

        return createRedditAndroidService().listPosts();
    }

    public Observable<List<CommentListing>> getListComments(String postId) {

        return createRedditAndroidService().listComments(postId);
    }

    public Observable<PostListing> getNextPagePostList(String afterId) {

        return createRedditAndroidService().getNextPage(afterId);
    }

    private RedditAndroidService createRedditAndroidService() {
        Retrofit retrofit = new RetrofitFactory().build();

        return retrofit.create(RedditAndroidService.class);
    }
}
