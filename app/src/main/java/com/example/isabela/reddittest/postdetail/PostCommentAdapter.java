package com.example.isabela.reddittest.postdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.PostComment;
import com.example.isabela.reddittest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostCommentAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<PostCommentModel> postCommentModelList = new ArrayList<>();

    public PostCommentAdapter(Context context) {
        this.context = context;
    }


    public void addComments(List<String> postComments) {

//        List<String> list = new ArrayList<>();
//        for(List<String> list: postComments) {
//            list.addAll(postComment.getComments());
//        }

        postCommentModelList.add(new PostCommentModel(postComments.get(0)));
        postCommentModelList.add(new PostCommentModel(postComments.get(1)));
        postCommentModelList.add(new PostCommentModel(postComments.get(2)));
        postCommentModelList.add(new PostCommentModel(postComments.get(0)));
        postCommentModelList.add(new PostCommentModel(postComments.get(1)));
        postCommentModelList.add(new PostCommentModel(postComments.get(2)));
        postCommentModelList.add(new PostCommentModel(postComments.get(0)));
        postCommentModelList.add(new PostCommentModel(postComments.get(1)));
        postCommentModelList.add(new PostCommentModel(postComments.get(2)));
        postCommentModelList.add(new PostCommentModel(postComments.get(0)));
        postCommentModelList.add(new PostCommentModel(postComments.get(1)));
        postCommentModelList.add(new PostCommentModel(postComments.get(2)));

        notifyDataSetChanged();
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
