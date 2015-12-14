package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public abstract class GlossaryBinder<T, H extends T> {

    private @LayoutRes int mViewType;
    private Class<H> mClass;

    public GlossaryBinder(@LayoutRes int viewType, Class<H> modelClass) {
        mViewType = viewType;
        mClass = modelClass;
    }

    public abstract GlossaryViewHolder<H> create(ViewGroup parent);

    public final boolean handlesViewType(T item) {
        return mClass.isInstance(item);
    }

    public @LayoutRes int getViewType() {
        return mViewType;
    }

}
