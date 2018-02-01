package com.example.isabela.reddittest;

import android.content.Context;

import com.example.isabela.reddittest.presentation.ListPostsActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isabela on 27/01/2018.
 */

public class UrlRetrofitBuilder {

    public UrlRetrofitBuilder() {
    }

    private static final String BASE_URL = "https://www.reddit.com/";

    public Retrofit createUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        return okhttpClientBuilder.build();
    }
}
