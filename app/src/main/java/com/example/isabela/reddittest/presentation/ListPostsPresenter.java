package com.example.isabela.reddittest.presentation;

import android.content.Context;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostListClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isabela on 31/01/2018.
 */

public class ListPostsPresenter {
    Context context;

    public ListPostsPresenter(Context context) {
        this.context = context;
    }

    public void loadPostList(final ListPostsAdapter listPostsAdapter) {

        //TODO diposable
        PostListClient postListClient = new PostListClient();
        Observable<Post> postObservable = postListClient.initObservable();

        postObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Post post) {
                        add(post, listPostsAdapter);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loadNextPostList(final ListPostsAdapter listPostsAdapter, final int totalItemsCount) {

        //TODO diposable
        PostListClient postListClient = new PostListClient();
        Observable<Post> postObservable = postListClient.initObservableNextPage(listPostsAdapter.getPostAfterId());

        postObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Post post) {
                        append(post, listPostsAdapter, totalItemsCount);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void add(Post post, ListPostsAdapter listPostsAdapter) {
        listPostsAdapter.addToPostList(post);
    }

    private void append(Post post, ListPostsAdapter listPostsAdapter, int totalItemsCount) {
        listPostsAdapter.appendOnPostList(post, totalItemsCount);
    }
}
