package com.example.isabela.reddittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by isabela on 27/01/2018.
 */

public interface ReeditService {
    @GET("/r/Android/new/.json")
    Call<Post> listPosts();

    //https://www.reddit.com/r/Android/new/.json?after=t3_7t96zs

    @GET("/r/Android/new/.json/after")
    Call<Post> getNextPage(@Query("t3_7t96zs") String after);  //paginacao

    @GET("/r/Android/comments/{id}/.json")
    Call<Post> listComments(@Path("id") String id);
}
