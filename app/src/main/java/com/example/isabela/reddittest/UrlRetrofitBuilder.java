package com.example.isabela.reddittest;

import android.content.Context;

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

    private Context context;

    public UrlRetrofitBuilder(Context context) {
        this.context = context;
    }

    private static final String BASE_URL = "https://www.reddit.com/";

    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new ConnectivityInterceptor(context))
            .build();

    public Retrofit createUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
