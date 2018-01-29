package com.example.isabela.reddittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by isabela on 25/01/2018.
 */

public class ListPostsAdapter extends RecyclerView.Adapter {

    private List<PostModel> listPostModel;
    private Context context;

    public ListPostsAdapter(List<PostModel> listPostModel, Context context) {
        this.listPostModel = listPostModel;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);

        PostViewHolder postViewHolder = new PostViewHolder(view);

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        PostViewHolder postViewHolder = (PostViewHolder) viewHolder;

        PostModel postModel = listPostModel.get(position);

        postViewHolder.postScore.setText(postModel.getPostScore());
        postViewHolder.postTitle.setText(postModel.getPostTitle());
//        postViewHolder.postPathImage.setImageURI("");

    }

    @Override
    public int getItemCount() {
        return listPostModel.size();
    }

}
