package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/14/2015.
 */
public class DefaultBinder<T> extends GlossaryBinder<T> {

    private @LayoutRes int mLayoutRes;

    public DefaultBinder(@LayoutRes int layoutRes) {
        super(null);
        mLayoutRes = layoutRes;
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(mLayoutRes, parent, false);
        return new EmptyHolder<>(itemView);
    }

    @Override
    public boolean handlesViewType(Object item) {
        return false;
    }
}
