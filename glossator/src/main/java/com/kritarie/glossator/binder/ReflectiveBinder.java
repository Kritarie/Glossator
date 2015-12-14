package com.kritarie.glossator.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kritarie.glossator.GlossaryViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Sean on 12/9/2015.
 */
public class ReflectiveBinder<T> extends GlossaryBinder<T> {

    private Constructor<? extends GlossaryViewHolder<T>> mConstructor;

    public ReflectiveBinder(int viewType, Class<T> modelClass, Class<? extends GlossaryViewHolder<T>> holderClass) {
        super(viewType, modelClass);
        try {
            mConstructor = holderClass.getConstructor(View.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("ViewHolder constructor not found. Implement a HolderFactory for non-default constructors.");
        }
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(getViewType(), parent, false);
        GlossaryViewHolder<T> holder;
        try {
            holder = mConstructor.newInstance(itemView);
        } catch (InstantiationException e) {
            throw new RuntimeException("ViewHolder could not be constructed. Verify layout resource.");
        } catch (InvocationTargetException e1) {
            throw new RuntimeException("ViewHolder could not be constructed.");
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("ViewHolder could not be constructed. Verify the constructor is accessible.");
        }
        return holder;
    }
}
