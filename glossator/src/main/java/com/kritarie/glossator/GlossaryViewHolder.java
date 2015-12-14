package com.kritarie.glossator;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Sean on 12/9/2015.
 */
public abstract class GlossaryViewHolder<T> extends RecyclerView.ViewHolder {

    public GlossaryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setContent(T content);
}
