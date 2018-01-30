package com.example.isabela.reddittest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isabela on 30/01/2018.
 */

public class Comment {
    List<PostComment> postComments;

    public List<PostComment> getPostComments() {
        return this.postComments;
    }
}
