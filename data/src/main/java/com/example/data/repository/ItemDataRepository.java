package com.example.data.repository;

import com.example.data.network.NetworkService;
import com.example.data.network.models.ItemDO;
import com.example.domain.base.UseCase;
import com.example.domain.interactors.ItemRepository;
import com.example.domain.models.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemDataRepository implements ItemRepository {

    private NetworkService service;
    private ItemDOToDomainConverter converter;

    @Inject
    public ItemDataRepository(NetworkService service, ItemDOToDomainConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public Observable<List<Item>> getItems(String query) {
        String path = "search";
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("keyword",query);
        return this.service.get(path,hashMap)
                .switchMap(response -> {
                    String responseString = response.body().content;
                    if (response.isSuccessful()) return Observable.just(Jsoup.parse(responseString));
                    else return Observable.error(NetWorkException.createInstance());
                })
                .map(document -> {
                    List<ItemDO> itemDOS = new ArrayList<>();
                    Elements elements = document.body()
                            .getElementById("bodyMainWrapper")
                            .getElementsByClass("pdItemWrap");
                    int i = 0;
                    while (i != elements.size()) {
                        Element e = elements.get(i).getElementsByTag("a")
                                .first();
                        String imgUri,name,price;
                        imgUri = e.getElementsByClass("thumbnail")
                                .attr("style");
                        if (imgUri != null && imgUri.length() > 0)
                            imgUri = imgUri.substring(imgUri.lastIndexOf("//") + 2,
                                    imgUri.lastIndexOf(")") - 1);
                        name = e.getElementsByClass("pdName")
                                .text();
                        price = e.getElementsByClass("pdNewPrice")
                                .text();
                        itemDOS.add(new ItemDO(name,price,imgUri));
                        i++;
                    }
                    return itemDOS;
                })
                .map(itemDOS -> {
                    List<Item> items = new ArrayList<>();
                    for (ItemDO itemDO : itemDOS) {
                        items.add(this.converter.convert(itemDO));
                    }
                    return items;

                });
    }
}
