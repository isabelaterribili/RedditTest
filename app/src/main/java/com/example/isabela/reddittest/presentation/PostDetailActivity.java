package com.example.isabela.reddittest.presentation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.isabela.reddittest.Comment;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostComment;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.postdetail.PostCommentAdapter;
import com.example.isabela.reddittest.postdetail.PostCommentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isabela on 29/01/2018.
 */

public class PostDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_activity_detail)
    Toolbar toolbar;

    @BindView(R.id.comments_recycler_view_cell)
    RecyclerView recyclerView;

    String postId = "7tukdd";

    List<PostCommentModel> postCommentModelList;
    PostCommentAdapter postCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);

        setUpToolbar();


        PostListClient postListClient = new PostListClient();

        Observable<List<PostComment>> postCommentObservable = postListClient.initObservableComments(postId);

        postCommentObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) //TODO diposable
                .subscribe(new Consumer<List<PostComment>>() {

                    @Override
                    public void accept(List<PostComment> postComments) throws Exception {
                        postComments.size();
                    }
                });

        postCommentModelList = new ArrayList<>();

        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));
        postCommentModelList.add(new PostCommentModel("Their icon looks like a broken Tide Pod. #cannotunsee", 1));

        postCommentAdapter = new PostCommentAdapter(postCommentModelList, PostDetailActivity.this);

        recyclerView.setAdapter(postCommentAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
    }


    public void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
