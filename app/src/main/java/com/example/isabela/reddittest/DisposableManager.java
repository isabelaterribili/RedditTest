package com.example.isabela.reddittest;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by isabela on 30/01/2018.
 */

public class DisposableManager {

    private CompositeDisposable compositeDisposable =
            new CompositeDisposable();
//    @Override public void onCreate() {
//        compositeDisposable.add(RedditAndroidService.listPosts()
//                .subscribe();

//
//    public void add(Disposable disposable) {
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
