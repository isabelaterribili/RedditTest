package com.example.isabela.reddittest.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostListing {

    @SerializedName("kind")
    private String kind;

    @SerializedName("data")
    private Data data;


    private PostListing(String kind, Data data) {
        this.kind = kind;
        this.data = data;
    }

    public PostListing() {

    }

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
        private String kindPost;

        @SerializedName("data")
        private Post post;

        public String getPostTitle() {
            return post.postTitle;
        }

        public String getThumbnailImage() {
            return post.thumbnailUri;
        }

        public int getPostScore() {
            return post.postScore;
        }

        public String getPostId() {
            return post.postId;
        }

        public String getPostUrl() {
            return post.urlPost;
        }

        public String getImageResolution() {
            if (post.imagePreview != null && post.imagePreview.imageSize.size() > 0) {
                return post.imagePreview.imageSize.get(0).imageSource.url;
            }
            return "";
        }
    }

    public class Post {
        @SerializedName("url")
        private String urlPost;

        @SerializedName("title")
        private String postTitle;

        @SerializedName("id")
        private String postId;

        @SerializedName("score")
        private int postScore;

        @SerializedName("preview")
        private ImagePreview imagePreview;

        @SerializedName("thumbnail")
        private String thumbnailUri;
    }

    private class ImagePreview {
        @SerializedName("images")
        private List<ImageInfo> imageSize;

    }

    private class ImageInfo {
        @SerializedName("source")
        private ImageSource imageSource;
    }

    private class ImageSource {
        @SerializedName("resolutions")
        private List<ImageResolutions> imageResolutions;

        @SerializedName("url")
        private String url;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;
    }

    private class ImageResolutions {
        @SerializedName("url")
        private String url;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;
    }

    public List<Child> getChildrenList() {
        return this.data.children;
    }

    public String getAfterId() {
        return this.data.afterId;
    }
}

