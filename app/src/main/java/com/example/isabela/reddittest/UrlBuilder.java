package com.example.isabela.reddittest;

import retrofit2.Retrofit;

/**
 * Created by isabela on 27/01/2018.
 */

public class UrlBuilder {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .build();
}
