package com.example.isabela.reddittest.postdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.PostModel;
import com.example.isabela.reddittest.PostViewHolder;
import com.example.isabela.reddittest.R;

import java.util.List;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostCommentAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<PostCommentModel> postCommentModelList;

    public PostCommentAdapter(List<PostCommentModel> postCommentModelList, Context context) {
        this.postCommentModelList = postCommentModelList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_row_item, parent, false);

        PostCommentViewHolder postCommentViewHolder = new PostCommentViewHolder(context, view);

        return postCommentViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        PostCommentViewHolder postViewHolder = (PostCommentViewHolder) viewHolder;

        PostCommentModel postCommentModel = postCommentModelList.get(position);

        postViewHolder.postComment.setText(postCommentModel.getCommentPost());
    }

    @Override
    public int getItemCount() {
        return postCommentModelList.size();
    }
}
