package com.example.isabela.reddittest.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListPostsActivity extends AppCompatActivity {

    @BindView(R.id.post_recycler_view_cell)
    RecyclerView recyclerViewPostCell;

    ListPostsAdapter listPostsAdapter;

    private ListPostsPresenter listPostsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);
        ButterKnife.bind(this);

        setUpToolbar();

        listPostsPresenter = new ListPostsPresenter(ListPostsActivity.this);

        listPostsAdapter = new ListPostsAdapter(ListPostsActivity.this);

        recyclerViewPostCell.setAdapter(listPostsAdapter);

        initRecyclerViewPostCellLayout(recyclerViewPostCell);

        listPostsPresenter.loadPostList(listPostsAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        clear disposable
    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_reddit_white);
        toolbar.setTitle(getString(R.string.list_title));
        setSupportActionBar(toolbar);
    }

    public void initRecyclerViewPostCellLayout(RecyclerView recyclerViewPostCell) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewPostCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerViewPostCell.addItemDecoration(recyclerViewDecoration);

    }
}


