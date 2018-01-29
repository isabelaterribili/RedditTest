package com.example.isabela.reddittest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView postTitle;
    ImageView postPathImage;
    TextView postScore;

    PostViewHolder(View view) {
        super(view);

        postTitle = (TextView) view.findViewById(R.id.post_title);
        postPathImage = (ImageView) view.findViewById(R.id.image_post);
        postScore = (TextView) view.findViewById(R.id.score);
    }

}
