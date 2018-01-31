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
import com.example.isabela.reddittest.RedditAndroidService;
import com.example.isabela.reddittest.UrlRetrofitBuilder;
import com.squareup.picasso.Picasso;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscription;
import rx.functions.Action1;


public class ListPostsActivity extends AppCompatActivity {

    @BindView(R.id.post_recycler_view_cell)
    RecyclerView recyclerView;

    List<PostModel> postModels;
    ListPostsAdapter adapter;

    String xablau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);
        ButterKnife.bind(this);

        setUpToolbar();

        adapter = new ListPostsAdapter(ListPostsActivity.this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration recyclerViewDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(recyclerViewDecoration);

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
        adapter.add(post);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

//        compositeDisposable.clear();
    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_reddit_white);
        toolbar.setTitle(getString(R.string.list_title));
        setSupportActionBar(toolbar);
    }
}


