package com.kritarie.glossator;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.kritarie.glossator.binder.EmptyBinder;
import com.kritarie.glossator.binder.FactoryBinder;
import com.kritarie.glossator.binder.HolderFactory;
import com.kritarie.glossator.binder.ReflectiveBinder;
import com.kritarie.glossator.listener.ListenerWrapper;
import com.kritarie.glossator.listener.OnAttachedToRecyclerListener;
import com.kritarie.glossator.listener.OnDetachedFromRecyclerListener;
import com.kritarie.glossator.listener.OnFailedRecycleListener;
import com.kritarie.glossator.listener.OnViewAttachedToWindowListener;
import com.kritarie.glossator.listener.OnViewDetachedFromWindowListener;
import com.kritarie.glossator.listener.OnViewRecycledListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 12/8/2015.
 */
public class Glossator<T> {

    @NonNull private final Glossary<T> mGlossary;
    @NonNull private final List<T> mListItems;
    @NonNull private final ListenerWrapper mListeners;

    private Glossator(@NonNull List<T> items) {
        mListItems = items;
        mGlossary = new Glossary<>();
        mListeners = new ListenerWrapper();
    }

    /* Static initializers */

    /**
     * Initialize a {@link Glossator>} with a {@link List>} of items.
     *
     * @param items the adapter will represent
     * @return a new {@link Glossator>} instance
     */
    public static <T> Glossator<T> with(@NonNull List<T> items) {
        return new Glossator<>(items);
    }

    /**
     * Initialize a {@link Glossator>} with an empty {@link List>}.
     * The generic type will need to be inferred.
     *
     * @return a new {@link Glossator>} instance
     */
    public static <T> Glossator<T> init() {
        return new Glossator<>(new ArrayList<T>());
    }

    /* Mapping Functions */

    /**
     * Register a mapping from the given viewType to a {@link GlossaryViewHolder} class.
     * Internally uses reflection to determine the default constructor.
     *
     * @param viewType to map
     * @param holderClass Class from which ViewHolders will be constructed
     * @return this {@link Glossator} for chaining
     */
    public <H extends T> Glossator<T> map(@LayoutRes int viewType, Class<H> modelClass, Class<? extends GlossaryViewHolder<H>> holderClass) {
        mGlossary.addBinder(new ReflectiveBinder<T, H>(viewType, modelClass, holderClass));
        return this;
    }

    /**
     * Register a mapping from the given viewType to a {@link HolderFactory} implementation.
     * Use this method as opposed to the reflective map if you need micro performance gains
     * or a non-default {@link GlossaryViewHolder} constructor.
     *
     * @param viewType to map
     * @param modelClass The model class that this ViewHolder should bind
     * @param factory which creates a {@link GlossaryViewHolder} for the given viewType
     * @return this {@link Glossator} for chaining
     */
    public <H extends T> Glossator<T> map(@LayoutRes int viewType, Class<H> modelClass, HolderFactory<T, H> factory) {
        mGlossary.addBinder(new FactoryBinder<>(viewType, modelClass, factory));
        return this;
    }

    /**
     * Register a mapping from the given viewType to an empty {@link GlossaryViewHolder}.
     * This method should be used only in the case where no information needs to be bound
     * to the view from the list.
     *
     * @param viewType to map
     * @param modelClass The model class that should receive this empty holder
     * @return this {@link Glossator} for chaining
     */
    public <H extends T> Glossator<T> map(@LayoutRes int viewType, Class<H> modelClass) {
        mGlossary.addBinder(new EmptyBinder<T, H>(viewType, modelClass));
        return this;
    }

    /* Optional Listeners */

    public Glossator<T> setListener(OnAttachedToRecyclerListener listener) {
        mListeners.add(listener);
        return this;
    }

    public Glossator<T> setListener(OnDetachedFromRecyclerListener listener) {
        mListeners.add(listener);
        return this;
    }

    public Glossator<T> setListener(OnFailedRecycleListener listener) {
        mListeners.add(listener);
        return this;
    }

    public Glossator<T> setListener(OnViewAttachedToWindowListener listener) {
        mListeners.add(listener);
        return this;
    }

    public Glossator<T> setListener(OnViewDetachedFromWindowListener listener) {
        mListeners.add(listener);
        return this;
    }

    public Glossator<T> setListener(OnViewRecycledListener listener) {
        mListeners.add(listener);
        return this;
    }

    public GlossaryAdapter build() {
        return new GlossaryAdapter<>(mGlossary, mListItems, mListeners);
    }
}
