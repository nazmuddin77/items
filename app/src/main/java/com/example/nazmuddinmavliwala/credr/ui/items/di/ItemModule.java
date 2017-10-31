package com.example.nazmuddinmavliwala.credr.ui.items.di;

import android.view.View;

import com.example.data.repository.ItemDOToDomainConverter;
import com.example.data.repository.ItemDataRepository;
import com.example.domain.interactors.ItemRepository;
import com.example.nazmuddinmavliwala.credr.R;
import com.example.nazmuddinmavliwala.credr.app.di.identifiers.ChildActivity;
import com.example.nazmuddinmavliwala.credr.base.views.ViewDelegate;
import com.example.nazmuddinmavliwala.credr.base.views.ViewManager;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;
import com.example.nazmuddinmavliwala.credr.ui.items.presenters.ItemDomainToVOConverter;
import com.example.nazmuddinmavliwala.credr.ui.items.views.activities.ItemListActivity;
import com.example.nazmuddinmavliwala.credr.ui.items.views.activities.ItemListView;
import com.example.nazmuddinmavliwala.credr.ui.items.views.viewdelgates.DataViewDelegate;
import com.example.nazmuddinmavliwala.credr.ui.items.views.viewdelgates.ErrorViewDelegate;
import com.example.nazmuddinmavliwala.credr.ui.items.views.viewdelgates.LoaderViewDelegate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */


@Module
@ChildActivity
public class ItemModule {

    private ItemListActivity activity;

    public ItemModule(ItemListActivity activity) {
        this.activity = activity;
    }

    @ChildActivity
    @Provides
    public ItemListView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public ItemRepository provideRepo(ItemDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    public ItemDOToDomainConverter provideDoToDomainConverter() {
        return new ItemDOToDomainConverter();
    }

    @ChildActivity
    @Provides
    public ItemDomainToVOConverter provideItemDomainToVOConverter() {
        return new ItemDomainToVOConverter();
    }
}
