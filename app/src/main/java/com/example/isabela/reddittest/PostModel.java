package com.example.isabela.reddittest;

/**
 * Created by isabela on 25/01/2018.
 */

public class PostModel {

    String postTitle;
    String imagePostPath;
    String channelName;

    public PostModel(String postTitle, String imagePostPath, String channelName) {
        this.postTitle = postTitle;
        this.imagePostPath = imagePostPath;
        this.channelName = channelName;
    }

    public PostModel(String postTitle, String channelName) {
        this.postTitle = postTitle;
        this.channelName = channelName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getImagePostPath() {
        return imagePostPath;
    }
}
