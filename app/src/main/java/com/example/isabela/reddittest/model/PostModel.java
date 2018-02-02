package com.example.isabela.reddittest.model;

public class PostModel {

    private final String postTitle;
    private final String postThumbnail;
    private final int postScore;
    private final String postId;
    private final String postUrl;
    private final String postImage;

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
