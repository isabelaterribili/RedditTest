package com.example.isabela.reddittest.client;

import com.example.isabela.reddittest.client.PostListClient;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isabela on 30/01/2018.
 */

public class DisposableManager {

    private CompositeDisposable compositeDisposable =
            new CompositeDisposable();
//    @Override public void onCreate() {
//        compositeDisposable.addToPostList(RedditAndroidService.listPosts()
//                .subscribe();

//
//    public void addToPostList(Disposable disposable) {
//        getCompositeDisposable().dispose();
//    }
//
//    private static CompositeDisposable getCompositeDisposable() {
//        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
//            compositeDisposable = new CompositeDisposable();
//        }
//        return compositeDisposable;
//    }

    public void createCompositeDisposable(PostListClient postListClient) {
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(postListClient.initObservable().subscribe());
    }
}
