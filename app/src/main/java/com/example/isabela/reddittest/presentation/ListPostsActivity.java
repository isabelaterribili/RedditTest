package com.example.isabela.reddittest.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;

import com.example.isabela.reddittest.ListPostsAdapter;
import com.example.isabela.reddittest.Post;
import com.example.isabela.reddittest.PostListClient;
import com.example.isabela.reddittest.PostModel;
import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.RedditAndroidService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListPostsActivity extends AppCompatActivity {

    List<PostModel> postModels;
    ListPostsAdapter adapter;
    PostListClient postListClient;
    Post postData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);

        setUpToolbar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditAndroidService redditAndroidService = retrofit.create(RedditAndroidService.class);


        Observable<Post> postObservable = redditAndroidService.listPosts();

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

        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", 5402));


        adapter = new ListPostsAdapter(postModels, ListPostsActivity.this);

        recyclerView.setAdapter(adapter);

        LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_reddit_white);
        toolbar.setTitle(getString(R.string.list_title));
        setSupportActionBar(toolbar);
    }
}


