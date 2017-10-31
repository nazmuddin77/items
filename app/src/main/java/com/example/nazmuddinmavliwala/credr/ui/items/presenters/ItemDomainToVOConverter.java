package com.example.nazmuddinmavliwala.credr.ui.items.presenters;

import com.example.domain.Converter;
import com.example.domain.models.Item;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemDomainToVOConverter implements Converter<Item,ItemVO> {
    @Override
    public ItemVO convert(Item data) {
        return new ItemVO(data.getName(),data.getImgUri(),data.getPrice());
    }
}
