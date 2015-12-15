package com.kritarie.glossator;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by Sean on 12/9/2015.
 */
public abstract class GlossaryViewHolder<T> extends RecyclerView.ViewHolder {

    public GlossaryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract <H extends T> void setContent(H content);

    public <H extends T> void setContent(H content, List<Object> payloads) {
        setContent(content);
    }
}
