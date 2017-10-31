package com.example.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 13/01/17.
 */
public interface RestService {

    @GET("{path}")
    Observable<Response<NetworkManager.Page>> get(
            @NonNull @Path("path") String path);

    @GET("{path}")
    Observable<Response<NetworkManager.Page>> get(
            @NonNull @Path("path") String path,
            @NonNull @QueryMap Map<String, String> queryMap
    );
}
