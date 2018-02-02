package com.example.isabela.reddittest.presentation.presenter;

import android.content.Context;

import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.presentation.adapter.ListPostsAdapter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListPostsPresenter {

    private Context context;

    public ListPostsPresenter(Context context) {
        this.context = context;
    }

    public void loadPostList(final ListPostsAdapter listPostsAdapter) {

        //TODO diposable
        PostListClient postListClient = new PostListClient();
        Observable<PostListing> postObservable = postListClient.initObservable();

        postObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostListing>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PostListing postListing) {
                        add(postListing, listPostsAdapter);
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
        Observable<PostListing> postObservable = postListClient.initObservableNextPage(listPostsAdapter.getPostAfterId());

        postObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostListing>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PostListing postListing) {
                        append(postListing, listPostsAdapter, totalItemsCount);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void add(PostListing postListing, ListPostsAdapter listPostsAdapter) {
        listPostsAdapter.addToPostList(postListing);
    }

    private void append(PostListing postListing, ListPostsAdapter listPostsAdapter, int totalItemsCount) {
        listPostsAdapter.appendOnPostList(postListing, totalItemsCount);
    }
}
