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
    private SparseArray<GlossaryBinder<T, ?>> mBinders = new SparseArray<>();

    public void addBinder(GlossaryBinder<T, ?> binder) {
        @LayoutRes int viewType = binder.getViewType();
        if (mBinders.get(viewType) != null) throw new IllegalArgumentException("A binder already exists for this type: " + viewType);
        mBinders.put(viewType, binder);
    }

    public GlossaryViewHolder createHolder(ViewGroup parent, @LayoutRes int viewType) {
        return mBinders.get(viewType).create(parent);
    }

    public int getItemViewType(List<T> listItems, int position) {
        T item = listItems.get(position);
        int count = mBinders.size();
        for (int i = 0; i < count; i++) {
            GlossaryBinder<T, ?> binder = mBinders.valueAt(i);
            if (binder.handlesViewType(item)) {
                return binder.getViewType();
            }
        }
        //If we couldn't find a binder for the item at this position, throw
        throw new RuntimeException("No binder available for " + item + " at position " + position);
    }
}
