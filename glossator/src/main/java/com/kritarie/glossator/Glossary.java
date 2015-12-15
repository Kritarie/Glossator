package com.kritarie.glossator;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.kritarie.glossator.binder.GlossaryBinder;

import java.util.List;

/**
 * Created by Sean on 12/8/2015.
 */
public class Glossary<T> {

    /* Binder Map */
    private SparseArray<GlossaryBinder<? extends T>> mBinders = new SparseArray<>();

    /* Default View Type */
    private @LayoutRes int mDefault = -1;

    public <H extends T> void addBinder(GlossaryBinder<H> binder) {
        @LayoutRes int viewType = binder.getViewType();
        if (mBinders.get(viewType) != null) throw new IllegalArgumentException("A binder already exists for this type: " + viewType);
        mBinders.put(viewType, binder);
    }

    public <H extends T> void setDefault(GlossaryBinder<H> binder) {
        // If there is already a default viewType set, throw
        if (mDefault != -1) throw new IllegalArgumentException("There can only be one default viewType.");
        mDefault = binder.getViewType();
        addBinder(binder);
    }

    public GlossaryViewHolder<? extends T> createHolder(ViewGroup parent, @LayoutRes int viewType) {
        return mBinders.get(viewType).create(parent);
    }

    public int getItemViewType(List<T> listItems, int position) {
        T item = listItems.get(position);
        int count = mBinders.size();
        for (int i = 0; i < count; i++) {
            GlossaryBinder<? extends T> binder = mBinders.valueAt(i);
            if (binder.handlesViewType(item)) {
                return binder.getViewType();
            }
        }

        // No binder for this item. Return default type if it was set.
        if (mDefault != -1) return mDefault;

        //If we couldn't find a binder for the item at this position and there is no default, throw
        throw new RuntimeException("No binder available for " + item + " at position " + position);
    }
}
