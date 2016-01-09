package com.kritarie.glossator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sean on 12/8/2015.
 */
public class GlossaryAdapter<T> extends RecyclerView.Adapter<GlossaryViewHolder> {

    @SuppressWarnings("NullableProblems") // Glossary set in builder
    @NonNull private Glossary<T> mGlossary;
    @SuppressWarnings("NullableProblems") // Items set in builder
    @NonNull private List<T> mListItems;

    public static final class Builder<T> {

        @Nullable private GlossaryAdapter<T> mAdapter;
        @NonNull private Glossary<T> mGlossary;
        @NonNull private List<T> mListItems;

        public Builder() {
            mListItems = Collections.emptyList();
            mGlossary = Glossary.empty();
        }

        public Builder<T> withItems(@NonNull List<T> items) {
            mListItems = items;
            return this;
        }

        public Builder<T> withGlossary(@NonNull Glossary<T> glossary) {
            mGlossary = glossary;
            return this;
        }

        public Builder<T> withAdapter(@NonNull GlossaryAdapter<T> adapter) {
            mAdapter = adapter;
            return this;
        }

        public GlossaryAdapter<T> build() {
            if (mAdapter == null) {
                mAdapter = new GlossaryAdapter<>();
            }
            mAdapter.setItems(mListItems);
            mAdapter.setGlossary(mGlossary);
            return mAdapter;
        }
    }

    @Override
    public final GlossaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mGlossary.createHolder(parent, viewType);
    }

    @Override
    public final void onBindViewHolder(GlossaryViewHolder holder, int position) {
        holder.setContent(mListItems.get(position));
    }

    @Override
    public final void onBindViewHolder(GlossaryViewHolder holder, int position, List<Object> payloads) {
        if (payloads != null && !payloads.isEmpty()) {
            holder.setContent(mListItems.get(position), payloads);
        } else {
            holder.setContent(mListItems.get(position));
        }
    }

    @Override
    public final int getItemViewType(int position) {
        return mGlossary.getItemViewType(mListItems, position);
    }

    @Override
    public final int getItemCount() {
        return mListItems.size();
    }

    /* Package */ final void setGlossary(@NonNull Glossary<T> glossary) {
        mGlossary = glossary;
    }

    /* Helper Methods */

    public void append(List<T> items) {
        int count = getItemCount();
        mListItems.addAll(items);
        notifyItemRangeInserted(count, mListItems.size() - 1);
    }

    @SafeVarargs
    public final void append(T... items) {
        int count = getItemCount();
        Collections.addAll(mListItems, items);
    }

    public void insert(int position, List<T> items) {
        mListItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size() - 1);
    }

    @SafeVarargs
    public final void insert(int position, T... items) {
        mListItems.addAll(position, Arrays.asList(items));
        notifyItemRangeInserted(position, position + items.length);
    }

    public void remove(int position) {
        mListItems.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(T item) {
        int index = mListItems.indexOf(item);
        if (mListItems.remove(item))
            notifyItemRemoved(index);
    }

    public @NonNull List<T> getListItems() {
        return mListItems;
    }

    public void setItems(@NonNull List<T> listItems) {
        this.mListItems = listItems;
        notifyItemRangeInserted(0, listItems.size() - 1);
    }
}
