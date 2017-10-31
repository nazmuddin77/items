package com.example.nazmuddinmavliwala.credr.ui.items.di;

import com.example.nazmuddinmavliwala.credr.app.di.identifiers.ChildActivity;
import com.example.nazmuddinmavliwala.credr.ui.items.views.activities.ItemListActivity;

import dagger.Subcomponent;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */


@ChildActivity
@Subcomponent(modules = ItemModule.class)
public interface ItemComponent {
    void inject(ItemListActivity activity);
}
