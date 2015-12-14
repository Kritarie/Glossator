package com.kritarie.glossator.sample;

import android.view.View;

import com.kritarie.glossator.GlossaryViewHolder;

/**
 * Created by Sean on 12/11/2015.
 */
public class CatHolder extends GlossaryViewHolder<Cat> {

    private Object someObject;

    public CatHolder(View itemView, Object someObject) {
        super(itemView);
        this.someObject = someObject;
    }

    @Override
    public void setContent(Cat content) {

    }
}
