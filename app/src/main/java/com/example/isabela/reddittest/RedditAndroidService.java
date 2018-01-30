package com.example.isabela.reddittest;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by isabela on 27/01/2018.
 */

public interface RedditAndroidService {
    @GET("r/Android/new/.json")
    Observable<Post> listPosts();

    //https://www.reddit.com/r/Android/new/.json?after=t3_7t96zs

    @GET("r/Android/new/.json/after")
    Observable<Post> getNextPage(@Query("t3_7t96zs") String after);  //paginacao

    @GET("r/Android/comments/{id}/.json")
    Observable<Comment> listComments(@Path("id") String id);

}
