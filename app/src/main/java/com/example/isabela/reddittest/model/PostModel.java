package com.example.isabela.reddittest.model;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostModel {

    private String postTitle;
    private String postThumbnail;
    private int postScore;

    private String postId;
    private String postUrl;
    private String postImage;


    public PostModel(String postTitle, String postThumbnail, int postScore, String postId, String postUrl, String postImage) {
        this.postTitle = postTitle;
        this.postThumbnail = postThumbnail;
        this.postScore = postScore;
        this.postId = postId;
        this.postUrl = postUrl;
        this.postImage = postImage;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostScore() {
        return Integer.toString(postScore);
    }

    public String getPostThumbnail() {
        return postThumbnail;
    }

    public String getPostId() {
        return postId;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public String getPostImage() {
        return postImage;
    }
}
