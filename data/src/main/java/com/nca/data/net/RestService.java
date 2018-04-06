package com.nca.data.net;

import android.arch.persistence.room.Insert;
import android.util.Log;

import com.nca.data.entity.ErrorRest;
import com.nca.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Singleton
public class RestService {

    private RestApi restApi;

    private ErrorTransformers errorTransformers;

    @Inject
    public RestService(RestApi restApi, ErrorTransformers errorTransformers) {
        this.errorTransformers = errorTransformers;
        this.restApi = restApi;
    }

//    @Inject
//    public RestService(RestApi restApi) {
//        this.restApi = restApi;
//    }

//    @Override
    public Observable<List<User>> loadUsers() {
        return restApi
                .loadUsers()
                .compose(errorTransformers.<List<User>, ErrorRest>parseHttpError());
    }

//    @Override
    public Observable<User> loadUserById(String id) {
        return restApi.loadUserById(id)
                .compose(errorTransformers.<User, ErrorRest>parseHttpError());
    }

    public Completable saveUserById(String id, User user) {
        Log.e("AAA", "onPreSave");
//        Log.e("User", user.toString());
        return restApi.saveUserById(id, user);
    }
}
