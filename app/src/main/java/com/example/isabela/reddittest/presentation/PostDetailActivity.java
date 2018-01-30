package com.example.isabela.reddittest.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.isabela.reddittest.R;

import butterknife.ButterKnife;

/**
 * Created by isabela on 29/01/2018.
 */

public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        setContentView(R.layout.activity_post_detail);
    }
}
