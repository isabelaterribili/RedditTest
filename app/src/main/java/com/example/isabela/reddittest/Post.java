package com.example.isabela.reddittest;

import android.net.Uri;
import android.provider.ContactsContract;

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
        String kindPost;

        @SerializedName("data")
        DataPost dataPost;

    }

    private class DataPost {
        @SerializedName("url")
        String urlPost;

        @SerializedName("title")
        String postTitle;

        @SerializedName("id")
        String postId; //Passar esse post id no Path para carregar os comentários

        @SerializedName("preview")
        ImagePreview imagePreview;

        @SerializedName("thumbnail")
        String thumbnailUri; // usar essa na lista de posts
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

        @SerializedName("url")   //devolve o tamanho de imagem padrão
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

    public String getKind() {
        return this.kind;


    }

    public DataList getDataList() {
        return this.dataList;
    }

    public List<Child> getChildrenList() {
        return this.dataList.children;
    }

    public String getPostTitle(int position) {
        return getChildrenList().get(position).dataPost.postTitle;
    }



}

