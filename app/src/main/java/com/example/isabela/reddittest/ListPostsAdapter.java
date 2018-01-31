package com.example.isabela.reddittest;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by isabela on 25/01/2018.
 */

public class ListPostsAdapter extends RecyclerView.Adapter {

    private List<PostModel> listPostModel = new ArrayList<>();;
    ;
    private Context context;

    public ListPostsAdapter(Context context) {
        this.context = context;
    }

    public void addToPostList(Post post) {

        post.getPostId(0);

        listPostModel.add(new PostModel(post.getPostTitle(0), post.getThumbnailImage(0), post.getPostScore(0)));
        listPostModel.add(new PostModel(post.getPostTitle(1), post.getThumbnailImage(1), post.getPostScore(1)));
        listPostModel.add(new PostModel(post.getPostTitle(2), post.getThumbnailImage(2), post.getPostScore(2)));
        listPostModel.add(new PostModel(post.getPostTitle(3), post.getThumbnailImage(3), 1));
        listPostModel.add(new PostModel(post.getPostTitle(4), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(5), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(6), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(7), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(8), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(9), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(10), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(11), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(12), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(13), "", 1));
        listPostModel.add(new PostModel(post.getPostTitle(14), "", 1));

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

        postViewHolder.postScore.setText(postModel.getPostScore());
        postViewHolder.postTitle.setText(postModel.getPostTitle());

        Uri uri = Uri.parse(postModel.getImagePostPath());
        Context context = ((PostViewHolder) viewHolder).postPathImage.getContext();

        Picasso.with(context).load(uri).into(((PostViewHolder) viewHolder).postPathImage);
    }

    @Override
    public int getItemCount() {
        return listPostModel.size();
    }

}
