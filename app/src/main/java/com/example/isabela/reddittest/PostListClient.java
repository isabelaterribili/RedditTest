package com.example.isabela.reddittest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class PostListClient {

    public Observable<Post> initObservable() {
        Observable<Post> postObservable = createRedditAndroidService().listPosts();

        return postObservable;
    }

    public Observable<List<PostComment>> initObservableComments(String postId) {
        Observable<List<PostComment>> postCommentObservable = createRedditAndroidService().listComments(postId);

        return postCommentObservable;
    }

    public Observable<Post> initObservableNextPage(String afterId) {
        Observable<Post> postObservable = createRedditAndroidService().getNextPage(afterId);

        return postObservable;
    }


    public RedditAndroidService createRedditAndroidService() {
        Retrofit urlRetrofitBuilder = new UrlRetrofitBuilder().createUrl();

        RedditAndroidService redditAndroidService = urlRetrofitBuilder.create(RedditAndroidService.class);

        return redditAndroidService;
    }
}
