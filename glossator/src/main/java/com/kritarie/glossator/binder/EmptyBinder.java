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

    public EmptyBinder(@LayoutRes int viewType, Class<T> modelClass) {
        super(viewType, modelClass);
    }

    @Override
    public GlossaryViewHolder<T> create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(getViewType(), parent, false);
        return new EmptyHolder<>(itemView);
    }

    private static class EmptyHolder<T> extends GlossaryViewHolder<T> {

        public EmptyHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setContent(T content) {
            // Do nothing
        }
    }
}
