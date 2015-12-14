package com.kritarie.glossator.binder;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public class FactoryBinder<T> extends GlossaryBinder<T> {

    private HolderFactory<T> mFactory;

    public FactoryBinder(@LayoutRes int viewType, Class<T> modelClass, HolderFactory<T> factory) {
        super(viewType, modelClass);
        mFactory = factory;
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(getViewType(), parent, false);
        return mFactory.create(itemView);
    }
}
