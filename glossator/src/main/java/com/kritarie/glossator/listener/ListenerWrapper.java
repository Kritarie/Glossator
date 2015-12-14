package com.kritarie.glossator.listener;

import android.support.annotation.Nullable;

/**
 * Created by Sean on 12/13/2015.
 */
public class ListenerWrapper {

    @Nullable private OnViewRecycledListener mViewRecycledListener;
    @Nullable private OnFailedRecycleListener mFailedRecycleListener;
    @Nullable private OnViewAttachedToWindowListener mViewAttachedToWindowListener;
    @Nullable private OnViewDetachedFromWindowListener mViewDetachedFromWindowListener;
    @Nullable private OnAttachedToRecyclerListener mAttachedToRecyclerListener;
    @Nullable private OnDetachedFromRecyclerListener mDetachedFromRecyclerListener;

    @Nullable
    public OnViewRecycledListener getViewRecycledListener() {
        return mViewRecycledListener;
    }

    @Nullable
    public OnFailedRecycleListener getFailedRecycleListener() {
        return mFailedRecycleListener;
    }

    @Nullable
    public OnViewAttachedToWindowListener getViewAttachedToWindowListener() {
        return mViewAttachedToWindowListener;
    }

    @Nullable
    public OnViewDetachedFromWindowListener getViewDetachedFromWindowListener() {
        return mViewDetachedFromWindowListener;
    }

    @Nullable
    public OnAttachedToRecyclerListener getAttachedToRecyclerListener() {
        return mAttachedToRecyclerListener;
    }

    @Nullable
    public OnDetachedFromRecyclerListener getDetachedFromRecyclerListener() {
        return mDetachedFromRecyclerListener;
    }

    public void add(OnViewRecycledListener listener) {
        mViewRecycledListener = listener;
    }

    public void add(OnFailedRecycleListener listener) {
        mFailedRecycleListener = listener;
    }

    public void add(OnViewAttachedToWindowListener listener) {
        mViewAttachedToWindowListener = listener;
    }

    public void add(OnViewDetachedFromWindowListener listener) {
        mViewDetachedFromWindowListener = listener;
    }

    public void add(OnAttachedToRecyclerListener listener) {
        mAttachedToRecyclerListener = listener;
    }

    public void add(OnDetachedFromRecyclerListener listener) {
        mDetachedFromRecyclerListener = listener;
    }

}
