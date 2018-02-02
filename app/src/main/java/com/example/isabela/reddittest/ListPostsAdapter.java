package com.example.isabela.reddittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.model.PostModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by isabela on 25/01/2018.
 */

public class ListPostsAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<PostModel> listPostModel = new ArrayList<>();

    private String postAfterId;

    public ListPostsAdapter(Context context) {
        this.context = context;
    }

    public void addToPostList(Post post) {
        this.postAfterId = post.getPostAfterId();

        for (Post.Child child : post.getChildrenList()) {
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

    public void append(Post post, int totalItemsCount) {
        this.postAfterId = post.getPostAfterId();

        for (Post.Child child : post.getChildrenList()) {
            listPostModel.add(new PostModel(
                    child.getPostTitle(),
                    child.getThumbnailImage(),
                    child.getPostScore(),
                    child.getPostId(),
                    child.getPostUrl(),
                    child.getImageResolution()));
        }
        notifyItemRangeInserted(listPostModel.size() - post.getChildrenList().size(), totalItemsCount);
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

}
