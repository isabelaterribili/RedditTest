package com.example.isabela.reddittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ListPostsActivity extends AppCompatActivity {

    List<PostModel> postModels;
    ListPostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_reddit);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        postModels = new ArrayList<>();

        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));
        postModels.add(new PostModel("What is something you hope to see in your lifetime?", "blablabla", "r/restofthefuckingowl"));

        adapter = new ListPostsAdapter(postModels, ListPostsActivity.this);

        recyclerView.setAdapter(adapter);

        LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

    }
}
