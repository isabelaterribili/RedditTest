package com.example.isabela.reddittest.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.PostModel;
import com.example.isabela.reddittest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ListPostsActivity extends AppCompatActivity {

    @BindView(R.id.post_recycler_view_cell)
    RecyclerView recyclerView;

    List<PostModel> postModels;
    ListPostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);
        ButterKnife.bind(this);

        setUpToolbar();

        PostListClient postListClient = new PostListClient();
        Observable<Post> postObservable = postListClient.initObservable();

        postObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Post>() {
                    @Override
                    public void accept(Post post) throws Exception {
                        post.getKind();
                        post.getDataList();
                    }
                });

        postModels = new ArrayList<>();

        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "https://b.thumbs.redditmedia.com/pNymZvykz6Fi1YUSDTwiX2VCsMO8WnGapolfmEpV9XA.jpg", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "https://b.thumbs.redditmedia.com/pNymZvykz6Fi1YUSDTwiX2VCsMO8WnGapolfmEpV9XA.jpg", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "https://b.thumbs.redditmedia.com/pNymZvykz6Fi1YUSDTwiX2VCsMO8WnGapolfmEpV9XA.jpg", 5402));

        adapter = new ListPostsAdapter(postModels, ListPostsActivity.this);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(recyclerViewDecoration);

    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_reddit_white);
        toolbar.setTitle(getString(R.string.list_title));
        setSupportActionBar(toolbar);
    }
}


