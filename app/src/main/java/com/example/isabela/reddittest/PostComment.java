package com.example.isabela.reddittest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isabela on 30/01/2018.
 */

public class PostComment {

    @SerializedName("kind")
    String kind;

    @SerializedName("data")
    DataList dataList;

    private class DataList {
        @SerializedName("after")
        String afterId;

        @SerializedName("before")
        String beforeId;

        @SerializedName("children")
        List<Child> children;
    }

    private class Child {

        @SerializedName("kind")
        String kind;

        @SerializedName("data")
        DataCommentList dataCommentList;
    }

    private class DataCommentList {

        @SerializedName("body")
        String commentPost;
    }

    public List<Child> getCommentPost() {
        return this.dataList.children;
    }
}
