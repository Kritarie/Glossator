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

    private static final int DEFAULT_VIEW_TYPE = Integer.MAX_VALUE;

    /* Binder Map */
    private SparseArray<GlossaryBinder<? extends T>> mBinders = new SparseArray<>();

    // Implementation provides unused int view type
    public <H extends T> void addBinder(GlossaryBinder<H> binder) {
        // Attempt autoincrement
        int viewType = mBinders.size();

        // Ensure this one is unused
        while (mBinders.get(viewType) != null) {
            viewType++;
        }

        mBinders.put(viewType, binder);
    }

    // Try to use the provided int view type, or throw if it is in use
    public <H extends T> void addBinder(int viewType, GlossaryBinder<H> binder) {
        if (mBinders.get(viewType) != null) throw new IllegalArgumentException("A binder already exists for this type: " + viewType);
        mBinders.put(viewType, binder);
    }

    public <H extends T> void setDefault(GlossaryBinder<H> binder) {
        // If there is already a default viewType set, throw
        if (mBinders.get(DEFAULT_VIEW_TYPE) != null) throw new IllegalArgumentException("There can only be one default viewType.");
        mBinders.put(DEFAULT_VIEW_TYPE, binder);
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
                return mBinders.keyAt(i);
            }
        }

        // No binder for this item. Return default type if it was set.
        if (mBinders.get(DEFAULT_VIEW_TYPE) != null) return DEFAULT_VIEW_TYPE;

        //If we couldn't find a binder for the item at this position and there is no default, throw
        throw new RuntimeException("No binder available for " + item + " at position " + position);
    }
}
