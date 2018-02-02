package com.example.isabela.reddittest.presentation.activity;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.client.DisposableManager;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.presentation.EndLessRecyclerViewScrollListener;
import com.example.isabela.reddittest.presentation.adapter.ListPostsAdapter;
import com.example.isabela.reddittest.presentation.presenter.ListPostsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListPostsActivity extends AppCompatActivity {

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.post_recycler_view_cell)
    RecyclerView recyclerViewPostCell;

    private ListPostsAdapter listPostsAdapter;

    private ListPostsPresenter listPostsPresenter;

    private EndLessRecyclerViewScrollListener scrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);
        ButterKnife.bind(this);

        setUpToolbar();

        pullToRefresh();

        listPostsPresenter = new ListPostsPresenter();
        listPostsAdapter = new ListPostsAdapter(ListPostsActivity.this);

        recyclerViewPostCell.setAdapter(listPostsAdapter);

        initRecyclerViewPostCellLayout(recyclerViewPostCell);

        ListPostsActivity.this.load();
    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_reddit_white);
        toolbar.setTitle(getString(R.string.list_title));
        setSupportActionBar(toolbar);
    }

    private void initRecyclerViewPostCellLayout(RecyclerView recyclerViewPostCell) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewPostCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerViewPostCell.addItemDecoration(recyclerViewDecoration);

        scrollListener = new EndLessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                callNextPage(totalItemsCount);
            }
        };
        recyclerViewPostCell.addOnScrollListener(scrollListener);
    }

    public void callNextPage(int totalItemsCount) {
        listPostsPresenter.paginatePostList(totalItemsCount,
                listPostsAdapter.getPostAfterId(),
                new ListPostsPresenter.PaginationListener() {
                    @Override
                    public void appendOnPostList(PostListing postListing, int totalItemsCount) {
                        listPostsAdapter.appendOnPostList(postListing, totalItemsCount);
                    }

                    @Override
                    public void onError() {
                        ListPostsActivity.this.onError();
                    }
                });
    }

    public void pullToRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listPostsAdapter.clear();
                listPostsAdapter.notifyItemRangeRemoved(0, listPostsAdapter.getItemCount());

                recyclerViewPostCell.removeAllViewsInLayout();

                scrollListener.resetState();

                ListPostsActivity.this.load();

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void load() {
        listPostsPresenter.loadPostList(new ListPostsPresenter.ListingListener() {
            @Override
            public void addToPostList(PostListing postListing) {
                listPostsAdapter.addToPostList(postListing);
            }

            @Override
            public void onError() {
                ListPostsActivity.this.onError();
            }
        });
    }

    public void onError() {
        View view = findViewById(R.id.activity_list_posts);
        Snackbar.make(view, R.string.no_connection_message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }
}



