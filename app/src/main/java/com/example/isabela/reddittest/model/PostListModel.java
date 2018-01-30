package com.example.isabela.reddittest.model;

import com.example.isabela.reddittest.PostModel;

import java.util.List;

/**
 * Created by isabela on 29/01/2018.
 */

public class PostListModel {

    private String postListAfter;
    private String postListBefore;
    private List<PostModel> postModelData;

    PostListModel(String postListAfter, String postListBefore, List<PostModel> postModelData) {
        this.postListAfter = postListAfter;
        this.postListBefore = postListBefore;
        this.postModelData = postModelData;
    }

    public String getPostListAfter() {
        return postListAfter;
    }

    public String getPostListBefore() {
        return postListAfter;
    }

    public List<PostModel> getPostModelData() {
        return postModelData;
    }

}
