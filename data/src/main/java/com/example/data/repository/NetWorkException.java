package com.example.data.repository;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class NetWorkException extends Throwable {

    public static NetWorkException createInstance() {
        return new NetWorkException();
    }
}
