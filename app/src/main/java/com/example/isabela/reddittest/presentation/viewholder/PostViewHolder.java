package com.example.isabela.reddittest.presentation.viewholder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.model.PostModel;
import com.example.isabela.reddittest.presentation.activity.PostDetailActivity;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private static final String POST_ID = "post_id";
    private static final String POST_TITLE = "post_title";
    private static final String POST_URL = "post_url";
    private static final String POST_URL_IMAGE = "post_url_image";

    private final Context context;
    private final TextView postTitle;
    private final ImageView postThumbnail;
    private final TextView postScore;
    private final View view;

    public PostViewHolder(Context context, View view) {
        super(view);

        this.context = context;
        this.view = view;
        this.postTitle = (TextView) view.findViewById(R.id.post_title);
        this.postThumbnail = (ImageView) view.findViewById(R.id.image_post);
        this.postScore = (TextView) view.findViewById(R.id.score);
    }

    public void bind(final PostModel postModel) {
        postTitle.setText(postModel.getPostTitle());

        Uri uri = Uri.parse(postModel.getPostThumbnail());
        Context postThumbnailContext = postThumbnail.getContext();

        Picasso.with(postThumbnailContext)
                .load(uri)
                .transform(new RoundedCornersTransformation(10, 10))
                .resize(150, 150)
                .centerCrop()
                .placeholder(R.drawable.ic_post_placeholder)
                .error(R.drawable.ic_post_placeholder)
                .into(postThumbnail);

        postScore.setText(postThumbnailContext.getString(R.string.score) + postModel.getPostScore());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PostDetailActivity.class);
                intent.putExtra(POST_ID, postModel.getPostId());
                intent.putExtra(POST_TITLE, postModel.getPostTitle());
                intent.putExtra(POST_URL, postModel.getPostUrl());
                intent.putExtra(POST_URL_IMAGE, postModel.getPostImage());
                context.startActivity(intent);
            }
        });
    }
}
