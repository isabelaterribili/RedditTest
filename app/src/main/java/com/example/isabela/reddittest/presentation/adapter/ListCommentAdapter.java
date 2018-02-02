package com.example.isabela.reddittest.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.model.CommentModel;
import com.example.isabela.reddittest.presentation.viewholder.CommentViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListCommentAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<CommentModel> commentModelList = new ArrayList<>();

    public ListCommentAdapter(Context context) {
        this.context = context;
    }


    public void addComments(List<String> postComments) {

        for (String comment : postComments) {
            commentModelList.add(new CommentModel(comment));
        }

        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_row_item, parent, false);

        CommentViewHolder commentViewHolder = new CommentViewHolder(context, view);

        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        CommentViewHolder postViewHolder = (CommentViewHolder) viewHolder;

        CommentModel commentModel = commentModelList.get(position);

        postViewHolder.bind(commentModel);
    }

    @Override
    public int getItemCount() {
        return commentModelList.size();
    }
}
