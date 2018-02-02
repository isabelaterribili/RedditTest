package com.example.isabela.reddittest.presentation.presenter;

import android.content.Context;

import com.example.isabela.reddittest.client.model.CommentListing;
import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.presentation.adapter.ListCommentAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentListPresenter {

    private Context context;

    public CommentListPresenter(Context context) {
        this.context = context;
    }

    public void loadCommentPostList(final ListCommentAdapter listCommentAdapter, String postId) {

        PostListClient postListClient = new PostListClient();

        Observable<List<CommentListing>> postCommentObservable = postListClient.initObservableComments(postId);

        postCommentObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) //TODO diposable
                .subscribe(new Observer<List<CommentListing>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<CommentListing> commentListings) {
                        List<String> list = new ArrayList<>();
                        for (CommentListing commentListing : commentListings) {
                            list.addAll(commentListing.getComments());
                        }
                        add(list, listCommentAdapter);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void add(List<String> postComments, ListCommentAdapter listCommentAdapter) {
        listCommentAdapter.addComments(postComments);
    }
}