package com.example.isabela.reddittest;

import android.net.Uri;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostModel {

    private String postTitle;
    private String imagePostPath;
    private int postScore;


    public PostModel(String postTitle, String imagePostPath, int postScore) {
        this.postTitle = postTitle;
        this.imagePostPath = imagePostPath;
        this.postScore = postScore;
    }

    public PostModel(String postTitle, int postScore) {
        this.postTitle = postTitle;
        this.postScore = postScore;
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

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

}
