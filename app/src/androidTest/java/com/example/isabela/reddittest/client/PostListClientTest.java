package com.example.isabela.reddittest.client;

import com.example.isabela.reddittest.client.model.CommentListing;
import com.example.isabela.reddittest.client.model.PostListing;
import com.example.isabela.reddittest.client.service.RedditAndroidService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class PostListClientTest {
    @Mock
    private RedditAndroidService service;

    @InjectMocks
    private PostListClient subject;

    @Test
    public void shouldValidateListPostsOnSuccess() {
        Mockito.when(service.listPosts()).thenReturn(Observable.just(new PostListing()));
        TestObserver<PostListing> test = subject.getListPost().test();
        test.awaitTerminalEvent();
        test.assertComplete().assertNoErrors();
    }

    @Test
    public void shouldValidateListPostsOnFailure() {
        Mockito.when(service.listPosts()).thenReturn(Observable.<PostListing>error(new TimeoutException()));
        TestObserver<PostListing> test = subject.getListPost().test();
        test.awaitTerminalEvent();
        test.assertError(TimeoutException.class);
    }

    @Test
    public void shouldValidateListCommentsOnSuccess() {
        Mockito.when(service.listComments("postId")).thenReturn(Observable.just(new ArrayList<CommentListing>()));
        TestObserver<ArrayList<CommentListing>> test = subject.getListComments("postId").test();
        test.awaitTerminalEvent();
        test.assertComplete().assertNoErrors();
    }

    @Test
    public void shouldValidateListCommentsOnError() {
        Mockito.when(service.listComments("postId")).thenReturn(Observable.<ArrayList<CommentListing>>error(new TimeoutException()));
        TestObserver<ArrayList<CommentListing>> test = subject.getListComments("postId").test();
        test.awaitTerminalEvent();
        test.assertError(TimeoutException.class);
    }

    @Test
    public void shouldValidateNextPagePostListOnSuccess() {
        Mockito.when(service.getNextPage("id")).thenReturn(Observable.just(new PostListing()));
        TestObserver<PostListing> test = subject.getNextPagePostList("id").test();
        test.awaitTerminalEvent();
        test.assertComplete().assertNoErrors();
    }

    @Test
    public void shouldValidateNextPagePostListOnError() {
        Mockito.when(service.getNextPage("id")).thenReturn(Observable.<PostListing>error(new TimeoutException()));
        TestObserver<PostListing> test = subject.getNextPagePostList("id").test();
        test.awaitTerminalEvent();
        test.assertError(TimeoutException.class);
    }
}