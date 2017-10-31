package com.example.nazmuddinmavliwala.credr.ui.items.views.adapters;

import android.content.Context;

import com.example.nazmuddinmavliwala.credr.base.views.recyclerview.AdapterDelegate;
import com.example.nazmuddinmavliwala.credr.base.views.recyclerview.ReactiveRecyclerAdapter;
import com.example.nazmuddinmavliwala.credr.ui.items.views.adapterdelegates.ItemsDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemsAdapter extends ReactiveRecyclerAdapter {

    private static final int ITEMS = 1;

    public ItemsAdapter(Context context) {
        super(context);
    }

    @Override
    protected List<AdapterDelegate> initAdapterDelegates() {
        List<AdapterDelegate> adapterDelegates = new ArrayList<>();
        adapterDelegates.add(new ItemsDelegate(ITEMS,this.context));
        return adapterDelegates;
    }

    @Override
    public void append(List<Object> items) {
        this.items.clear();
        super.append(items);
    }
}
