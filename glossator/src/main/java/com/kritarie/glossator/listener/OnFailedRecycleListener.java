package com.kritarie.glossator.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Sean on 12/13/2015.
 */
public interface OnFailedRecycleListener {
    boolean onFailedToRecycleView(RecyclerView.ViewHolder holder);
}
