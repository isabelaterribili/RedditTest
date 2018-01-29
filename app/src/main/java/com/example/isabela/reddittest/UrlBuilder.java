package com.example.isabela.reddittest;

import io.reactivex.Scheduler;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isabela on 27/01/2018.
 */

public class UrlBuilder {
    private static final String BASE_URL = "https://www.reddit.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
