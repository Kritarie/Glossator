package com.kritarie.glossator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kritarie.glossator.listener.ListenerWrapper;
import com.kritarie.glossator.listener.OnFailedRecycleListener;
import com.kritarie.glossator.listener.OnAttachedToRecyclerListener;
import com.kritarie.glossator.listener.OnViewAttachedToWindowListener;
import com.kritarie.glossator.listener.OnDetachedFromRecyclerListener;
import com.kritarie.glossator.listener.OnViewDetachedFromWindowListener;
import com.kritarie.glossator.listener.OnViewRecycledListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sean on 12/8/2015.
 */
public class GlossaryAdapter<T> extends RecyclerView.Adapter<GlossaryViewHolder> {

    @NonNull private Glossary<T> mGlossary;
    @NonNull private List<T> mListItems;

    /* Optional adapter listeners */
    @Nullable private OnViewRecycledListener mViewRecycledListener;
    @Nullable private OnFailedRecycleListener mFailedRecycleListener;
    @Nullable private OnViewAttachedToWindowListener mViewAttachedToWindowListener;
    @Nullable private OnViewDetachedFromWindowListener mViewDetachedFromWindowListener;
    @Nullable private OnAttachedToRecyclerListener mAttachedToRecyclerListener;
    @Nullable private OnDetachedFromRecyclerListener mDetachedFromRecyclerListener;

    public GlossaryAdapter(@NonNull Glossary<T> glossary, @NonNull List<T> items, @NonNull ListenerWrapper listeners) {
        mGlossary = glossary;
        mListItems = items;
        mViewRecycledListener = listeners.getViewRecycledListener();
        mFailedRecycleListener = listeners.getFailedRecycleListener();
        mViewAttachedToWindowListener = listeners.getViewAttachedToWindowListener();
        mViewDetachedFromWindowListener = listeners.getViewDetachedFromWindowListener();
        mAttachedToRecyclerListener = listeners.getAttachedToRecyclerListener();
        mDetachedFromRecyclerListener = listeners.getDetachedFromRecyclerListener();
    }

    @Override
    public GlossaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mGlossary.createHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(GlossaryViewHolder holder, int position) {
        holder.setContent(mListItems.get(position));
    }

    @Override
    public void onBindViewHolder(GlossaryViewHolder holder, int position, List<Object> payloads) {
        holder.setContent(mListItems.get(position), payloads);
    }

    @Override
    public int getItemViewType(int position) {
        return mGlossary.getItemViewType(mListItems, position);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    /* Helper Methods */

    public final void append(List<T> items) {
        int count = getItemCount();
        mListItems.addAll(items);
        notifyItemRangeInserted(count, mListItems.size() - 1);
    }

    @SafeVarargs
    public final void append(T... items) {
        int count = getItemCount();
        Collections.addAll(mListItems, items);
    }

    public final void insert(int position, List<T> items) {
        mListItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size() - 1);
    }

    @SafeVarargs
    public final void insert(int position, T... items) {
        mListItems.addAll(position, Arrays.asList(items));
        notifyItemRangeInserted(position, position + items.length);
    }

    public final void remove(int position) {
        mListItems.remove(position);
        notifyItemRemoved(position);
    }

    public final void remove(T item) {
        int index = mListItems.indexOf(item);
        if (mListItems.remove(item))
            notifyItemRemoved(index);
    }

    public List<T> getListItems() {
        return mListItems;
    }

    public void setItems(List<T> listItems) {
        this.mListItems = listItems;
        notifyItemRangeInserted(0, listItems.size() - 1);
    }

    /* Listener Impl */

    @Override
    public void onViewRecycled(GlossaryViewHolder holder) {
        if (mViewRecycledListener != null) {
            mViewRecycledListener.onViewRecycled(holder);
        }
    }

    @Override
    public boolean onFailedToRecycleView(GlossaryViewHolder holder) {
        if (mFailedRecycleListener != null) {
            return mFailedRecycleListener.onFailedToRecycleView(holder);
        } else {
            return super.onFailedToRecycleView(holder);
        }
    }

    @Override
    public void onViewAttachedToWindow(GlossaryViewHolder holder) {
        if (mViewAttachedToWindowListener != null) {
            mViewAttachedToWindowListener.onViewAttachedToWindow(holder);
        }
    }

    @Override
    public void onViewDetachedFromWindow(GlossaryViewHolder holder) {
        if (mViewDetachedFromWindowListener != null) {
            mViewDetachedFromWindowListener.onViewDetachedFromWindow(holder);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (mAttachedToRecyclerListener != null) {
            mAttachedToRecyclerListener.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (mDetachedFromRecyclerListener != null) {
            mDetachedFromRecyclerListener.onDetachedFromRecyclerView(recyclerView);
        }
    }

    /* Listener Setters */

    public void setViewRecycledListener(OnViewRecycledListener listener) {
        mViewRecycledListener = listener;
    }

    public void setFailedRecycleListener(OnFailedRecycleListener listener) {
        mFailedRecycleListener = listener;
    }

    public void setViewAttachedToWindowListener(OnViewAttachedToWindowListener listener) {
        mViewAttachedToWindowListener = listener;
    }

    public void setViewDetachedFromWindowListener(OnViewDetachedFromWindowListener listener) {
        mViewDetachedFromWindowListener = listener;
    }

    public void setViewAttachedToRecyclerListener(OnAttachedToRecyclerListener listener) {
        mAttachedToRecyclerListener = listener;
    }

    public void setViewDetachedFromRecyclerListener(OnDetachedFromRecyclerListener listener) {
        mDetachedFromRecyclerListener = listener;
    }
}
