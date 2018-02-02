package com.example.isabela.reddittest.presentation.activity;

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

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.client.DisposableManager;
import com.example.isabela.reddittest.presentation.adapter.ListCommentAdapter;
import com.example.isabela.reddittest.presentation.presenter.CommentListPresenter;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class PostDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_activity_detail)
    Toolbar toolbar;

    @BindView(R.id.comments_recycler_view_cell)
    RecyclerView recyclerViewCommentCell;

    @BindView(R.id.post_detail_title)
    TextView postDetailTitle;

    @BindView(R.id.post_detail_url)
    TextView postDetailUrl;

    @BindView(R.id.post_image_detail)
    ImageView postImageDetail;

    private String postId;
    private String postTitle;
    private String postUrl;
    private String postImageUrl;

    private static final String POST_ID = "post_id";
    private static final String POST_TITLE = "post_title";
    private static final String POST_URL = "post_url";
    private static final String POST_URL_IMAGE = "post_url_image";

    private ListCommentAdapter listCommentAdapter;
    private CommentListPresenter commentListPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getExtras();

        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);
        setUpToolbar();

        commentListPresenter = new CommentListPresenter(PostDetailActivity.this);

        listCommentAdapter = new ListCommentAdapter(PostDetailActivity.this);

        recyclerViewCommentCell.setAdapter(listCommentAdapter);

        initRecyclerViewCellLayout(recyclerViewCommentCell);

        commentListPresenter.loadCommentPostList(listCommentAdapter, postId);

        postDetailTitle.setText(postTitle);
        postDetailUrl.setText(postUrl);
        loadPostImageDetail(postImageUrl);
    }

    public void getExtras() {
        postId = getIntent().getExtras().getString(POST_ID);
        postTitle = getIntent().getExtras().getString(POST_TITLE);
        postUrl = getIntent().getExtras().getString(POST_URL);
        postImageUrl = getIntent().getExtras().getString(POST_URL_IMAGE);
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

    public void initRecyclerViewCellLayout(RecyclerView recyclerViewCommentCell) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewCommentCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerViewCommentCell.addItemDecoration(recyclerViewDecoration);
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

        Picasso.with(this)
                .load(uri)
                .transform(new RoundedCornersTransformation(10, 10))
                .resize(300, 300)
                .centerCrop()
                .placeholder(R.drawable.ic_post_placeholder)
                .error(R.drawable.ic_post_placeholder)
                .into(postImageDetail);
    }

    @Override
    public void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }
}
