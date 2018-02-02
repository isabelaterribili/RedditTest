package com.example.isabela.reddittest.client;

import com.example.isabela.reddittest.client.service.RedditAndroidService;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.model.CommentListing;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class PostListClient {

    public Observable<PostListing> initObservable() {
        Observable<PostListing> postObservable = createRedditAndroidService().listPosts();

        return postObservable;
    }

    public Observable<List<CommentListing>> initObservableComments(String postId) {
        Observable<List<CommentListing>> postCommentObservable = createRedditAndroidService().listComments(postId);

        return postCommentObservable;
    }

    public Observable<PostListing> initObservableNextPage(String afterId) {
        Observable<PostListing> postObservable = createRedditAndroidService().getNextPage(afterId);

        return postObservable;
    }


    private RedditAndroidService createRedditAndroidService() {
        Retrofit retrofit = new RetrofitFactory().build();

        RedditAndroidService redditAndroidService = retrofit.create(RedditAndroidService.class);

        return redditAndroidService;
    }
}
