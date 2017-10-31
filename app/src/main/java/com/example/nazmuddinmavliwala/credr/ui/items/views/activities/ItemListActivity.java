package com.example.nazmuddinmavliwala.credr.ui.items.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.nazmuddinmavliwala.credr.R;
import com.example.nazmuddinmavliwala.credr.base.views.BaseActivity;
import com.example.nazmuddinmavliwala.credr.base.views.ViewManager;
import com.example.nazmuddinmavliwala.credr.ui.items.di.ItemModule;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;
import com.example.nazmuddinmavliwala.credr.ui.items.presenters.ItemPresenter;
import com.example.nazmuddinmavliwala.credr.ui.items.views.adapters.ItemsAdapter;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemListActivity extends BaseActivity implements ItemListView {

    @Inject
    ItemPresenter presenter;

    @BindView(R.id.rv_data)
    RecyclerView recyclerView;

    @BindView(R.id.et_item)
    EditText etItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideItemComponent(new ItemModule(this))
                .inject(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        ItemsAdapter adapter = new ItemsAdapter(this);
        recyclerView.setAdapter(adapter);
        RxTextView.textChanges(etItem)
                .debounce(200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .filter(charSequence -> charSequence.length() > 0)
                .subscribe(charSequence -> this.presenter.fetchItems(charSequence.toString()));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_items;
    }

    @Override
    public void bind(List<ItemVO> items) {
        List<Object> objects = new ArrayList<>();
        objects.addAll(items);
        ((ItemsAdapter)recyclerView.getAdapter()).append(objects);
    }
}
