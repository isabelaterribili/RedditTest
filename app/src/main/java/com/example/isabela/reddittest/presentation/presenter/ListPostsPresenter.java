package com.example.isabela.reddittest.presentation.presenter;

import com.example.isabela.reddittest.client.DisposableManager;
import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.client.RetrofitFactory;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.service.RedditAndroidService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListPostsPresenter {
    private final PostListClient client;

    public ListPostsPresenter() {
        this.client = new PostListClient(new RetrofitFactory().build().create(RedditAndroidService.class));
    }

    public void loadPostList(final ListingListener listener) {
        client.getListPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostListing>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        DisposableManager.add(disposable);
                    }

                    @Override
                    public void onNext(@NonNull PostListing postListing) {
                        listener.addToPostList(postListing);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void paginatePostList(final int totalItemsCount, String postAfterId, final PaginationListener listener) {
        client.getNextPagePostList(postAfterId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostListing>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        DisposableManager.add(disposable);
                    }

                    @Override
                    public void onNext(@NonNull PostListing postListing) {
                        listener.appendOnPostList(postListing, totalItemsCount);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public interface ListingListener {
        void addToPostList(PostListing postListing);
        void onError();
    }

    public interface PaginationListener {
        void appendOnPostList(PostListing postListing, int totalItemsCount);
        void onError();
    }
}
