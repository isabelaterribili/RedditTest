package com.example.isabela.reddittest;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PostListClient {

    public void initObservable() {
        Retrofit urlRetrofitBuilder = new UrlRetrofitBuilder().createUrl();

        RedditAndroidService redditAndroidService = urlRetrofitBuilder.create(RedditAndroidService.class);

        Observable<Post> postObservable = redditAndroidService.listPosts();

        postObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Post>() {
                    @Override
                    public void accept(Post post) throws Exception {
                        post.getKind();
                        post.getDataList();
                    }
                });


    }
}
