package com.example.isabela.reddittest.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ListPostsActivity extends AppCompatActivity {

    @BindView(R.id.post_recycler_view_cell)
    RecyclerView recyclerViewPostCell;

    ListPostsAdapter listPostsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);
        ButterKnife.bind(this);

        setUpToolbar();

        listPostsAdapter = new ListPostsAdapter(ListPostsActivity.this);
        recyclerViewPostCell.setAdapter(listPostsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewPostCell.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
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
                        add(post);
                    }
                });
    }

    private void add(Post post) {
        listPostsAdapter.addToPostList(post);
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
}


