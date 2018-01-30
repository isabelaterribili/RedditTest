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

    TextView postTitle;
    ImageView postPathImage;
    TextView postScore;
    Context context;

    PostViewHolder(Context context, View view) {
        super(view);

        this.postTitle = (TextView) view.findViewById(R.id.post_title);
        this.postPathImage = (ImageView) view.findViewById(R.id.image_post);
        this.postScore = (TextView) view.findViewById(R.id.score);

        this.context = context;

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, PostDetailActivity.class); //Passar para próxima activity o id para listar os comentários
        context.startActivity(intent);
    }
}
