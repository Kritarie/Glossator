package com.kritarie.glossator.binder;

import android.view.View;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public interface HolderFactory<T, H extends T> {
    GlossaryViewHolder<H> create(View itemView);
    boolean builds(T item);
}
