package com.kritarie.glossator.binder;

import android.view.View;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/14/2015.
 */
public class EmptyHolder<T> extends GlossaryViewHolder<T> {

    public EmptyHolder(View itemView) {
        super(itemView);
    }

    @Override
    public <H extends T> void setContent(H content) { /* No Impl */ }

}
