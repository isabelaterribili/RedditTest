package com.example.isabela.reddittest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabela.reddittest.model.PostModel;
import com.example.isabela.reddittest.presentation.PostDetailActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String POST_ID = "post_id";
    private static final String POST_TITLE = "post_title";
    private static final String POST_URL = "post_url";
    private static final String POST_URL_IMAGE = "post_url_image";


    private Context context;
    private PostModel model;

    private TextView postTitle;
    private ImageView postThumbnail;
    private TextView postScore;

    PostViewHolder(Context context, View view) {
        super(view);

        this.context = context;

        this.postTitle = (TextView) view.findViewById(R.id.post_title);
        this.postThumbnail = (ImageView) view.findViewById(R.id.image_post);
        this.postScore = (TextView) view.findViewById(R.id.score);

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        intent.putExtra(POST_ID, model.getPostId());
        intent.putExtra(POST_TITLE, model.getPostTitle());
        intent.putExtra(POST_URL, model.getPostUrl());
        intent.putExtra(POST_URL_IMAGE, model.getPostImage());
        context.startActivity(intent);
    }

    public void setModel(PostModel postModel) {
        model = postModel;
        postTitle.setText(postModel.getPostTitle());

        Uri uri = Uri.parse(postModel.getPostThumbnail());
        Context context = postThumbnail.getContext();

        Picasso.with(context).load(uri).into(postThumbnail);

        postScore.setText(context.getString(R.string.score) + postModel.getPostScore());
    }
}
