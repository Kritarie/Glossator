package com.kritarie.glossator.binder;

import android.view.View;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public interface HolderFactory<T> {
    GlossaryViewHolder<T> create(View itemView);
}
