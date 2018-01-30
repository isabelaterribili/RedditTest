package com.example.isabela.reddittest.postdetail;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostCommentModel {

    private String commentPost;
    private int commentScore;


    public PostCommentModel(String commentPost, int commentScore) {
        this.commentPost = commentPost;
        this.commentScore = commentScore;
    }


    public String getCommentPost() {
        return commentPost;
    }


    public String getCommentStore() {
        return Integer.toString(commentScore);
    }
}
