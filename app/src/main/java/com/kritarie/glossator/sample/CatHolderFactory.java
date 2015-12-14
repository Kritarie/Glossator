package com.kritarie.glossator.sample;

import android.view.View;

import com.kritarie.glossator.GlossaryViewHolder;
import com.kritarie.glossator.binder.HolderFactory;

/**
 * Created by Sean on 12/11/2015.
 */
public class CatHolderFactory implements HolderFactory<Animal, Cat> {

    @Override
    public GlossaryViewHolder<Cat> create(View itemView) {
        return new CatHolder(itemView, new Object());
    }

    @Override
    public boolean builds(Animal item) {
        return item instanceof Cat;
    }
}
