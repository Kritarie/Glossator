package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public abstract class GlossaryBinder<T> {

    private @LayoutRes int mViewType;
    private Class<T> mClass;

    public GlossaryBinder(@LayoutRes int viewType, Class<T> modelClass) {
        mViewType = viewType;
        mClass = modelClass;
    }

    public abstract GlossaryViewHolder<T> create(ViewGroup parent);

    public boolean handlesViewType(Object item) {
        return mClass.isInstance(item);
    }

    public @LayoutRes int getViewType() {
        return mViewType;
    }

}
