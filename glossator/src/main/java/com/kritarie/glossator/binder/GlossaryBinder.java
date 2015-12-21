package com.kritarie.glossator.binder;

import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public abstract class GlossaryBinder<T> {

    private Class<T> mClass;

    public GlossaryBinder(Class<T> modelClass) {
        mClass = modelClass;
    }

    public abstract GlossaryViewHolder<T> create(ViewGroup parent);

    public boolean handlesViewType(Object item) {
        return mClass.isInstance(item);
    }
}
