package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/12/2015.
 */
public class EmptyBinder<T> extends GlossaryBinder<T> {

    private @LayoutRes int mLayoutRes;

    public EmptyBinder(Class<T> modelClass, @LayoutRes int layoutRes) {
        super(modelClass);
        mLayoutRes = layoutRes;
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(mLayoutRes, parent, false);
        return new EmptyHolder<>(itemView);
    }
}
