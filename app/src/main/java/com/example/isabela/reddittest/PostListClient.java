package com.example.isabela.reddittest;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class PostListClient {

    public Observable<Post> initObservable() {
        Retrofit urlRetrofitBuilder = new UrlRetrofitBuilder().createUrl();

        RedditAndroidService redditAndroidService = urlRetrofitBuilder.create(RedditAndroidService.class);

        Observable<Post> postObservable = redditAndroidService.listPosts();

        return postObservable;
    }

    public Observable<Comment> initObservableComments(String postId) {
        Retrofit urlRetrofitBuilder = new UrlRetrofitBuilder().createUrl();

        RedditAndroidService redditAndroidService = urlRetrofitBuilder.create(RedditAndroidService.class);

        Observable<Comment> postCommentObservable = redditAndroidService.listComments(postId); // passar o valor do id do post

        return postCommentObservable;
    }
}
