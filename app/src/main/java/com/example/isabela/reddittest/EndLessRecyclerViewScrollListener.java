package com.example.isabela.reddittest;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by isabela on 01/02/2018.
 */

public abstract class EndLessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    private int currentPage = 0;
    private int previousTotalItemCount = 0;
    private boolean loading = true;
    private int visibleStarted = 5;
    private int startingPageIndex = 0;

    RecyclerView.LayoutManager mLayoutManager;

    public EndLessRecyclerViewScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {

        int lastVisibleItemPosition = 0;
        int totalItemCount = mLayoutManager.getItemCount();

        if (mLayoutManager instanceof LinearLayoutManager) {
            lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        }

        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }

        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }

        if (!loading && (lastVisibleItemPosition + visibleStarted) > totalItemCount) {
            currentPage++;
            onLoadMore(currentPage, totalItemCount, view);
            loading = true;
        }
    }

    public abstract void onLoadMore(int page, int totalItemsCount, RecyclerView view);

}
