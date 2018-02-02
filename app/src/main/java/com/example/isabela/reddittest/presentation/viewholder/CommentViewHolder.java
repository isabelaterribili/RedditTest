package com.example.isabela.reddittest.presentation.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.model.CommentModel;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private final TextView commentText;
    private final ImageView imagePostDetail;

    public CommentViewHolder(Context context, View view) {
        super(view);

        this.context = context;
        this.commentText = (TextView) view.findViewById(R.id.comment);
        this.imagePostDetail = (ImageView) view.findViewById(R.id.comment_placeholder);
    }

    public void bind(CommentModel commentModel) {
        commentText.setText(commentModel.getCommentPost());
        imagePostDetail.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_icon_reddit_comment));
    }
}
