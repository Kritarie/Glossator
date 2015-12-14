package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public class FactoryBinder<T, H extends T> extends GlossaryBinder<T, H> {

    private HolderFactory<T, H> mFactory;

    public FactoryBinder(@LayoutRes int viewType, Class<H> modelClass, HolderFactory<T, H> factory) {
        super(viewType, modelClass);
        mFactory = factory;
    }

    @Override
    public GlossaryViewHolder<H> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(getViewType(), parent, false);
        return mFactory.create(itemView);
    }
}
