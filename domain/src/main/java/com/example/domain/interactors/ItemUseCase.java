package com.example.domain.interactors;

import com.example.domain.base.UseCase;
import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;
import com.example.domain.models.Item;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemUseCase extends UseCase<ItemRepository> {


    @Inject
    public ItemUseCase(ExecutionThread executionThread,
                       PostExecutionThread postExecutionThread,
                       ItemRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void fetchItems(String query, Subscriber<List<Item>> subscriber) {
        this.repository.getItems(query)
                .compose(applySchedulers())
                .subscribe(subscriber);
    }
}
