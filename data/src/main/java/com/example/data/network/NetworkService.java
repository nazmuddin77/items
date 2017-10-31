package com.example.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 13/01/17.
 */
public interface NetworkService {

    Observable<Response<NetworkManager.Page>> get(@NonNull String path);

    Observable<Response<NetworkManager.Page>> get(@NonNull String path, @NonNull Map<String, String> headerMap);
}
