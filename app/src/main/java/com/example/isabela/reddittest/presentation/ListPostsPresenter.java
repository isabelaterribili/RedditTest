package com.example.isabela.reddittest.presentation;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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


    public void loadPostList(RecyclerView recyclerViewPostCell, final ListPostsAdapter listPostsAdapter) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewPostCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(context, LinearLayoutManager.VERTICAL);
        recyclerViewPostCell.addItemDecoration(recyclerViewDecoration);


        //TODO diposable
        PostListClient postListClient = new PostListClient();
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
