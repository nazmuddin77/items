package com.example.data.repository;

import com.example.data.network.models.ItemDO;
import com.example.domain.Converter;
import com.example.domain.models.Item;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemDOToDomainConverter implements Converter<ItemDO,Item> {

    @Override
    public Item convert(ItemDO data) {
        return new Item(data.getName(),data.getImgUri(),data.getPrice());
    }
}
