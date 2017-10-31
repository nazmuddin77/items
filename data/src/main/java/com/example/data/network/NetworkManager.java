package com.example.data.network;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 13/01/17.
 */

@Singleton
public class NetworkManager implements NetworkService {

    private RestService service;

    @Inject
    public NetworkManager(RestService service) {
        this.service = service;
    }

    @Override
    public Observable<Response<Page>> get(@NonNull String path) {
        return this.service.get(path);
    }

    @Override
    public Observable<Response<Page>> get(@NonNull String path, @NonNull Map<String, String> headerMap) {
        return this.service.get(path, headerMap);
    }

    public static class Page {
        public String content;

        Page(String content) {
            this.content = content;
        }

    }

    public static final class PageAdapter implements Converter<ResponseBody, Page> {
        public static final Converter.Factory FACTORY = new Converter.Factory() {
            @Override
            public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                if (type == Page.class) return new PageAdapter();
                return null;
            }
        };

        @Override
        public Page convert(ResponseBody responseBody) throws IOException {
            return new Page(responseBody.string());
        }
    }




}
