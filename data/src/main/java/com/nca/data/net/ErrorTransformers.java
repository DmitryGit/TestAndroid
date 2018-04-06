package com.nca.data.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nca.data.entity.Error;
import com.nca.data.entity.ErrorType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

public class ErrorTransformers {

    private Gson gson;

    @Inject
    public ErrorTransformers(Gson gson) {
        this.gson = gson;
    }

    @Singleton
    public <Model, ErrorThrowable extends Error>ObservableTransformer<Model, Model> parseHttpError() {

        return new ObservableTransformer<Model, Model>() {
            @Override
            public ObservableSource<Model> apply(Observable<Model> upstream) {

                return upstream.onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Model>>() {
                    @Override
                    public ObservableSource<? extends Model> apply(Throwable throwable) throws Exception {


                        if (throwable instanceof SocketTimeoutException) {
                            return Observable.error(new Error(ErrorType.SERVER_NOT_AVALIBLE));

                        } else if (throwable instanceof IOException) {
                            return Observable.error(new Error(ErrorType.NO_INTERNET));

                        } else if (throwable instanceof HttpException) {
                            HttpException httpException = (HttpException) throwable;
                            String bodyError = (String) httpException.response().body();

                            Type errorType = new TypeToken<ErrorThrowable>(){}.getType();
                            ErrorThrowable errorThrowable = gson.fromJson(bodyError, errorType);

                            return Observable.error(errorThrowable);
//                            return Observable.error(new Error(ErrorType.SERVER_ERROR));
                        } else {
                            return Observable.error(new Error(ErrorType.UNKNOWN));
                        }
                    }
                });

            }
        };
    }


}
