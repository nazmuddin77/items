package com.example.nazmuddinmavliwala.credr.ui.items.views.activities;

import com.example.nazmuddinmavliwala.credr.base.presenters.BaseView;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public interface ItemListView extends BaseView {

    void bind(List<ItemVO> objects);
}
