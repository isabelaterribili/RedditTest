package com.example.isabela.reddittest;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by isabela on 27/01/2018.
 */

public interface RedditAndroidService {
    @GET("r/Android/new/.json")
    Observable<Post> listPosts();

    @GET("r/Android/new/.json/after")
    Observable<Post> getNextPage(@Query("t3_7t96zs") String after);

    @GET("r/Android/comments/{id}/.json")
    Observable<List<PostComment>> listComments(@Path("id") String id);

}
