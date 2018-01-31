package com.example.isabela.reddittest;

import android.net.Uri;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostModel {

    private String postTitle;
    private String imagePostPath;
    private int postScore;
    private String postId;


    public PostModel(String postTitle, String imagePostPath, int postScore, String postId) {
        this.postTitle = postTitle;
        this.imagePostPath = imagePostPath;
        this.postScore = postScore;
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }


    public String getPostScore() {
        return Integer.toString(postScore);
    }

    public String getImagePostPath() {
        return imagePostPath;
    }

    public String getPostId() {
        return postId;
    }


}
