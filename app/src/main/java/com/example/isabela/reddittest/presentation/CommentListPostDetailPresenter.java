package com.example.isabela.reddittest.presentation;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostComment;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.postdetail.ListCommentAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isabela on 01/02/2018.
 */

public class CommentListPostDetailPresenter {

    public CommentListPostDetailPresenter(Context context) {
        this.context = context;
    }

    Context context;


    public void loadCommentPostList(final ListCommentAdapter listCommentAdapter, String postId) {

        PostListClient postListClient = new PostListClient(context);

        Observable<List<PostComment>> postCommentObservable = postListClient.initObservableComments(postId);

        postCommentObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) //TODO diposable
                .subscribe(new Consumer<List<PostComment>>() {

                    @Override
                    public void accept(List<PostComment> postComments) throws Exception {
                        List<String> list = new ArrayList<>();
                        for (PostComment postComment : postComments) {
                            list.addAll(postComment.getComments());
                        }
                        add(list, listCommentAdapter);
                    }
                });
    }

    public void add(List<String> postComments, ListCommentAdapter listCommentAdapter) {
        listCommentAdapter.addComments(postComments);
    }
}
