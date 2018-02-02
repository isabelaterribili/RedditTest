package com.example.isabela.reddittest.presentation.presenter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.client.DisposableManager;
import com.example.isabela.reddittest.client.RetrofitFactory;
import com.example.isabela.reddittest.client.model.CommentListing;
import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.client.service.RedditAndroidService;
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

    private final Context context; //TODO REMOVER CONTEXT
    private final PostListClient client;

    public CommentListPresenter(Context context) {
        this.context = context;
        this.client = new PostListClient(new RetrofitFactory().build().create(RedditAndroidService.class));
    }

    public void loadCommentPostList(final ListCommentAdapter listCommentAdapter, String postId, final View view) {

        Observable<List<CommentListing>> postCommentObservable = client.getListComments(postId);

        postCommentObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) //TODO diposable
                .subscribe(new Observer<List<CommentListing>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        DisposableManager.add(disposable);
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
                        Snackbar.make(view, R.string.no_connection_message, Snackbar.LENGTH_SHORT).show();
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
