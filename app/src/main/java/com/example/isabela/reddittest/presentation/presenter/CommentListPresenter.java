package com.example.isabela.reddittest.presentation.presenter;

import com.example.isabela.reddittest.client.DisposableManager;
import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.client.RetrofitFactory;
import com.example.isabela.reddittest.client.model.CommentListing;
import com.example.isabela.reddittest.client.service.RedditAndroidService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentListPresenter {

    private final PostListClient client;
    private final Scheduler scheduler;

    public CommentListPresenter() {
        this(new PostListClient(new RetrofitFactory().build().create(RedditAndroidService.class)), AndroidSchedulers.mainThread());
    }

    public CommentListPresenter(PostListClient client, Scheduler scheduler) {
        this.client = client;
        this.scheduler = scheduler;
    }

    public void loadCommentPostList(String postId, final ListingListener listener) {
        client.getListComments(postId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(scheduler)
                .subscribe(new Observer<ArrayList<CommentListing>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        DisposableManager.add(disposable);
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<CommentListing> commentListings) {
                        List<String> list = new ArrayList<>();
                        for (CommentListing commentListing : commentListings) {
                            list.addAll(commentListing.getComments());
                        }
                        listener.addToCommentList(list);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    public interface ListingListener {
        void addToCommentList(List<String> list);
        void onError();
    }
}
