package com.example.domain.interactors;

import com.example.domain.base.Repository;
import com.example.domain.models.Item;

import java.util.List;

import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public interface ItemRepository extends Repository {

    Observable<List<Item>> getItems(String query);
}
