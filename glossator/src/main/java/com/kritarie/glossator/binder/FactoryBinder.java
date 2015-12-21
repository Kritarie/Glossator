package com.kritarie.glossator.binder;

import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public class FactoryBinder<T> extends GlossaryBinder<T> {

    private HolderFactory<T> mFactory;

    public FactoryBinder(Class<T> modelClass, HolderFactory<T> factory) {
        super(modelClass);
        mFactory = factory;
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        return mFactory.create(parent);
    }
}
