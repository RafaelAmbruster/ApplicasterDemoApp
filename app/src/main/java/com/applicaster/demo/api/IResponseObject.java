package com.applicaster.demo.api;

/**
 * Created by Ambruster on 3/9/2017.
 * Helper interface for handle call services events
 */

public interface IResponseObject<T> {

    void onResponse(T object);

    void onError(String message, Integer code);

}