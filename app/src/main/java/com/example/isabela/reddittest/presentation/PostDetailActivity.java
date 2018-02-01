package com.example.isabela.reddittest.presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabela.reddittest.PostComment;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.postdetail.PostCommentAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    RecyclerView recyclerViewCommentCell;

    @BindView(R.id.post_detail_title)
    TextView postDetailTitle;

    @BindView(R.id.post_image_detail)
    ImageView postImageDetail;

    String postId;
    String postTitle;
    String postUrl;
    String postImageUrl;

    private static final String POST_ID = "post_id";
    private static final String POST_TITLE = "post_title";
    private static final String POST_URL = "post_url";
    private static final String POST_URL_IMAGE = "post_url_image";

    PostCommentAdapter postCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        postId = getIntent().getExtras().getString(POST_ID);
        postTitle = getIntent().getExtras().getString(POST_TITLE);
        postUrl = getIntent().getExtras().getString(POST_URL);
        postImageUrl = getIntent().getExtras().getString(POST_URL_IMAGE);


                setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);
        setUpToolbar();

        postCommentAdapter = new PostCommentAdapter(PostDetailActivity.this);
        recyclerViewCommentCell.setAdapter(postCommentAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewCommentCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
        recyclerViewCommentCell.addItemDecoration(recyclerViewDecoration);


        postDetailTitle.setText(postTitle);
        loadPostImageDetail(postImageUrl);

        PostListClient postListClient = new PostListClient();

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
                        add(list);
                    }
                });
    }

    public void add(List<String> postComments) {
        postCommentAdapter.addComments(postComments);
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

    public void navigateToCustomChromeTabs(String postDetailUrl) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();

        builder.setToolbarColor(getColor(R.color.prussion_blue));

        customTabsIntent.launchUrl(this, Uri.parse(postDetailUrl));
    }

    @OnClick(R.id.post_detail)
    void post_detail() {
        navigateToCustomChromeTabs(postUrl);
    }

    public void loadPostImageDetail(String postImageUrl) {
        Uri uri = Uri.parse(postImageUrl);

        Picasso.with(this).load(uri).into(postImageDetail);
    }
}
