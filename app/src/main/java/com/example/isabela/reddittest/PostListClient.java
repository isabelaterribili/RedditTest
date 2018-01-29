package com.example.isabela.reddittest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by isabela on 29/01/2018.
 */

public class PostListClient {

    private RedditAndroidService redditAndroidService;

    public List<Post> getPostList() {
        Observable<Post> call = redditAndroidService.listPosts();
        return (List<Post>) call;
    }

//    Observable<Post> call = redditAndroidService.listPosts();
//    Disposable disposable = call
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new Disposable<Post>() {
//                }
//            })
}
