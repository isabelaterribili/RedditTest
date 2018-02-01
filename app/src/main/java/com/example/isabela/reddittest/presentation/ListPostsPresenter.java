package com.example.isabela.reddittest.presentation;

import android.content.Context;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostListClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
        PostListClient postListClient = new PostListClient(context);
        Observable<Post> postObservable = postListClient.initObservable();

        postObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Post>() {
                    @Override
                    public void accept(Post post) throws Exception {
                        add(post, listPostsAdapter);
                    }
                });
    }

    private void add(Post post, ListPostsAdapter listPostsAdapter) {
        listPostsAdapter.addToPostList(post);
    }
}
