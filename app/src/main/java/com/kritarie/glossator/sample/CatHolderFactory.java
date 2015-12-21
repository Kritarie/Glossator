package com.kritarie.glossator.sample;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;
import com.kritarie.glossator.binder.HolderFactory;

/**
 * Created by Sean on 12/11/2015.
 */
public class CatHolderFactory implements HolderFactory<Cat> {

    private @LayoutRes int mLayoutRes;
    private Object someObject;

    public CatHolderFactory(@LayoutRes int layoutRes, Object someObject) {
        mLayoutRes = layoutRes;
        this.someObject = someObject;
    }

    @Override
    public GlossaryViewHolder<Cat> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(mLayoutRes, parent, false);
        return new CatHolder(itemView, someObject);
    }
}
