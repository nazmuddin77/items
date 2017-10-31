package com.example.nazmuddinmavliwala.credr.ui.items.views.adapterdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.nazmuddinmavliwala.credr.R;
import com.example.nazmuddinmavliwala.credr.base.views.recyclerview.AbstractAdapterDelegate;
import com.example.nazmuddinmavliwala.credr.base.views.recyclerview.AdapterDelegate;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;
import com.example.nazmuddinmavliwala.credr.ui.items.views.viewholders.ItemsViewHolder;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemsDelegate extends AbstractAdapterDelegate<List<Object>> {

    public ItemsDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof ItemVO;
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((ItemsViewHolder)holder).bind((ItemVO) items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new ItemsViewHolder(this.context,itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.items_row;
    }
}
