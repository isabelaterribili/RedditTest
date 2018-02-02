package com.example.isabela.reddittest.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.R;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.model.PostModel;
import com.example.isabela.reddittest.presentation.viewholder.PostViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListPostsAdapter extends RecyclerView.Adapter {

    private Context context;
    private String postAfterId;
    private List<PostModel> listPostModel = new ArrayList<>();

    public ListPostsAdapter(Context context) {
        this.context = context;
    }

    public void addToPostList(PostListing postListing) {
        this.postAfterId = postListing.getAfterId();

        for (PostListing.Child child : postListing.getChildrenList()) {
            listPostModel.add(new PostModel(
                    child.getPostTitle(),
                    child.getThumbnailImage(),
                    child.getPostScore(),
                    child.getPostId(),
                    child.getPostUrl(),
                    child.getImageResolution()));
        }
        notifyDataSetChanged();
    }

    public void appendOnPostList(PostListing postListing, int totalItemsCount) {
        this.postAfterId = postListing.getAfterId();

        for (PostListing.Child child : postListing.getChildrenList()) {
            listPostModel.add(new PostModel(
                    child.getPostTitle(),
                    child.getThumbnailImage(),
                    child.getPostScore(),
                    child.getPostId(),
                    child.getPostUrl(),
                    child.getImageResolution()));
        }
        notifyItemRangeInserted(listPostModel.size() - postListing.getChildrenList().size(), totalItemsCount);
    }

    public String getPostAfterId() {
        return postAfterId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_row_item, parent, false);

        PostViewHolder postViewHolder = new PostViewHolder(context, view);

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        PostViewHolder postViewHolder = (PostViewHolder) viewHolder;

        PostModel postModel = listPostModel.get(position);

        postViewHolder.bind(postModel);
    }

    @Override
    public int getItemCount() {
        return listPostModel.size();
    }

    public void clear() {
        listPostModel.clear();
    }

}
