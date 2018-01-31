package com.example.isabela.reddittest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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

    public class Child {

        @SerializedName("kind")
        String kind;

        @SerializedName("data")
        DataCommentList dataCommentList;
    }

    private class DataCommentList {

        @SerializedName("body")
        String commentPost;
    }

    public List<String> getComments() {
        List<String> list = new ArrayList<>();

        for (Child child : this.dataList.children) {
            if ("t1".equals(child.kind))
                list.add(child.dataCommentList.commentPost);
        }
        return list;
    }
}
