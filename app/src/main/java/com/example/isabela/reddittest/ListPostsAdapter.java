package com.example.isabela.reddittest;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isabela.reddittest.model.PostListModel;
import com.example.isabela.reddittest.model.PostModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by isabela on 25/01/2018.
 */

public class ListPostsAdapter extends RecyclerView.Adapter {

    private List<PostModel> listPostModel = new ArrayList<>();

    private PostListModel postModelListInfo;

    private Context context;

    public ListPostsAdapter(Context context) {
        this.context = context;
    }

    public void addToPostList(Post post) {
        postModelListInfo = new PostListModel(post.getPostAfterId());

        for (Post.Child child : post.getChildrenList()) {
            listPostModel.add(new PostModel(
                    child.getPostTitle(),
                    child.getThumbnailImage(),
                    child.getPostScore(),
                    child.getPostId(),
                    child.getPostUrl()));
        }
        notifyDataSetChanged();
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

        postViewHolder.setModel(postModel);
    }

    @Override
    public int getItemCount() {
        return listPostModel.size();
    }

}
