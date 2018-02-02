package com.example.isabela.reddittest.presentation.presenter;

import com.example.isabela.reddittest.client.PostListClient;
import com.example.isabela.reddittest.client.model.CommentListing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

@RunWith(MockitoJUnitRunner.class)
public class CommentListPresenterTest {

//    @Test
//    public void shouldValidateLoadCommentPostList() {
//        PostListClient client = Mockito.mock(PostListClient.class);
//        Scheduler scheduler = Mockito.mock(Scheduler.class);
//
//        CommentListPresenter subject = new CommentListPresenter(client, scheduler);
//        Mockito.when(client.getListComments("postId")).thenReturn(Observable.just(new ArrayList<CommentListing>()));
//
//        CommentListPresenter.ListingListener mock = Mockito.mock(CommentListPresenter.ListingListener.class);
//        subject.loadCommentPostList("postId", mock);
//        Mockito.verify(mock, Mockito.only()).addToCommentList(Mockito.<String>anyList());
//    }
}