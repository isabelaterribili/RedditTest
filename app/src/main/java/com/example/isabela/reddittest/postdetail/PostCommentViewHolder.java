package com.example.isabela.reddittest.postdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.isabela.reddittest.R;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostCommentViewHolder extends RecyclerView.ViewHolder {

    TextView postComment;
    Context context;


    public PostCommentViewHolder(Context context, View view) {
        super(view);
        this.postComment = (TextView) view.findViewById(R.id.comment);

        this.context = context;
    }
}
