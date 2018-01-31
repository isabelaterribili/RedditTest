package com.example.isabela.reddittest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isabela.reddittest.presentation.PostDetailActivity;

import butterknife.ButterKnife;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String POST_ID = "post_id";
    private static final String POST_TITLE = "post_title";

    TextView postTitle;
    ImageView postPathImage;
    TextView postScore;
    String postId;
    Context context;

    PostViewHolder(Context context, View view) {
        super(view);

        this.context = context;

        this.postTitle = (TextView) view.findViewById(R.id.post_title);
        this.postPathImage = (ImageView) view.findViewById(R.id.image_post);
        this.postScore = (TextView) view.findViewById(R.id.score);

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, PostDetailActivity.class); //Passar para próxima activity o id para listar os comentários
        intent.putExtra(POST_ID, postId);
//        intent.putExtra(POST_TITLE, postTitle);
        context.startActivity(intent);
    }
}
