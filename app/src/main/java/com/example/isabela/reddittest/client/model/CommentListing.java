package com.example.isabela.reddittest.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CommentListing {

    @SerializedName("kind")
    private String kind;

    @SerializedName("data")
    private Data data;

    private class Data {
        @SerializedName("after")
        private String afterId;

        @SerializedName("before")
        private String beforeId;

        @SerializedName("children")
        private List<Child> children;
    }

    public class Child {
        @SerializedName("kind")
        private String kind;

        @SerializedName("data")
        private Comment comment;
    }

    private class Comment {
        @SerializedName("body")
        private String commentPost;
    }

    public List<String> getComments() {
        List<String> list = new ArrayList<>();

        for (Child child : this.data.children) {
            if ("t1".equals(child.kind))
                list.add(child.comment.commentPost);
        }
        return list;
    }
}
