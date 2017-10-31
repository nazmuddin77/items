package com.example.nazmuddinmavliwala.credr.ui.items.presenters;

import android.support.v7.view.menu.MenuView;

import com.example.domain.interactors.ItemUseCase;
import com.example.domain.models.Item;
import com.example.nazmuddinmavliwala.credr.base.presenters.BasePresenter;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;
import com.example.nazmuddinmavliwala.credr.ui.items.views.activities.ItemListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemPresenter extends BasePresenter<ItemListView> {

    private ItemUseCase useCase;
    private final ItemDomainToVOConverter converter;

    @Inject
    public ItemPresenter(ItemListView view,
                         ItemUseCase useCase,
                         ItemDomainToVOConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void fetchItems(String query) {
        this.useCase.fetchItems(query, new Subscriber<List<Item>>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(List<Item> items) {
                List<ItemVO> objects = new ArrayList<>();
                for (Item item : items) {
                    objects.add(converter.convert(item));
                }
                view.bind(objects);
            }
        });
    }
}
