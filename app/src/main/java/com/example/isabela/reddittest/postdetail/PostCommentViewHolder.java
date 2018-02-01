package com.example.isabela.reddittest.postdetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabela.reddittest.R;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostCommentViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private TextView postComment;
    private ImageView imagePostDetail;


    public PostCommentViewHolder(Context context, View view) {
        super(view);

        this.context = context;
        this.postComment = (TextView) view.findViewById(R.id.comment);
        this.imagePostDetail = (ImageView) view.findViewById(R.id.comment_placeholder);
    }

    public void setModel(PostCommentModel postCommentModel) {
        postComment.setText(postCommentModel.getCommentPost());
        imagePostDetail.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_icon_reddit_comment));
    }
}
