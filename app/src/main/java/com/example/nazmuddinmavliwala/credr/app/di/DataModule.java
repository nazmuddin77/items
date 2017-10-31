package com.example.nazmuddinmavliwala.credr.app.di;


import android.content.Context;

import com.example.data.network.NetworkManager;
import com.example.data.network.NetworkService;
import com.example.data.network.RestService;
import com.example.data.network.RxErrorHandlingCallAdapterFactory;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Module
public class DataModule {

    private static final String API_BASE_URL = "https://m.snapdeal.com/";

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor, @Named("Application") Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return  new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(NetworkManager.PageAdapter.FACTORY)
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public RestService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService(NetworkManager manager) {
        return manager;
    }


}
