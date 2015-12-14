package com.kritarie.glossator;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Sean on 12/11/2015.
 */
public abstract class AdapterListener {

    public void onViewRecycled(GlossaryViewHolder holder) {
    }

    public boolean onFailedToRecycleView(GlossaryViewHolder holder) {
        return false;
    }

    public void onViewAttachedToWindow(GlossaryViewHolder holder) {
    }

    public void onViewDetachedFromWindow(GlossaryViewHolder holder) {
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

}
