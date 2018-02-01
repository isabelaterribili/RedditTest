package com.example.isabela.reddittest;

import android.app.DownloadManager;
import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by isabela on 01/02/2018.
 */

public class ConnectivityInterceptor implements Interceptor {

    private Context context;

    public ConnectivityInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
//        if(NetworkUtils.isOnline(context)) {
//            throw new NoConnectivityException();
//        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public class NoConnectivityException extends IOException {

        @Override
        public String getMessage() {
            return "No connectivity exception";
        }

    }
}
