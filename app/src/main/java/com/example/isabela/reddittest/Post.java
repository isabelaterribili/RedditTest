package com.example.isabela.reddittest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isabela on 28/01/2018.
 */

public class Post {

    Post(String kind, DataList dataList) {
        this.kind = kind;
        this.dataList = dataList;
    }

    public Post() {

    }

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
        String kindPost;

        @SerializedName("data")
        DataPost dataPost;

        public String getPostTitle() {
            return dataPost.postTitle;
        }

        public String getThumbnailImage() {
            return dataPost.thumbnailUri;
        }

        public int getPostScore() {
            return dataPost.postScore;
        }

        public String getPostId() {
            return dataPost.postId;
        }

        public String getPostUrl() {
            return dataPost.urlPost;
        }

        public String getImageResolution() {
            if(dataPost.imagePreview != null && dataPost.imagePreview.imageSize.size() > 0) {
                return dataPost.imagePreview.imageSize.get(0).imageSource.url;
            }
            return "https://api.partio.com.br/images/flavio-schiavini-abe-210x210x-af2e7.jpg";
        }
    }

    public class DataPost {
        @SerializedName("url")
        String urlPost;

        @SerializedName("title")
        String postTitle;

        @SerializedName("id")
        String postId;

        @SerializedName("score")
        int postScore;

        @SerializedName("preview")
        ImagePreview imagePreview;

        @SerializedName("thumbnail")
        String thumbnailUri;
    }

    private class ImagePreview {
        @SerializedName("images")
        List<ImageInfo> imageSize;

    }

    private class ImageInfo {
        @SerializedName("source")
        ImageSource imageSource;

    }

    private class ImageSource {
        @SerializedName("resolutions")
        List<ImageResolutions> imageResolutions;

        @SerializedName("url") //padrão do reddit
        String url;

        @SerializedName("width")
        int width;

        @SerializedName("height")
        int height;
    }

    private class ImageResolutions {
        @SerializedName("url")
        String url;

        @SerializedName("width")
        int width;

        @SerializedName("height")
        int height;
    }

    public List<Child> getChildrenList() {
        return this.dataList.children;
    }

    public String getPostAfterId() {
        return this.dataList.afterId;
    }
}

