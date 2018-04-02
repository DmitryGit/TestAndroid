package com.nca.data.net;

import android.util.Log;

import com.nca.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

//    @Override
    public Observable<List<User>> loadUsers() {
        return restApi
                .loadUsers();
//                .compose();
    }

//    @Override
    public Observable<User> loadUserById(String id) {
        return restApi.loadUserById(id);
    }

    public Completable saveUserById(String id, User user) {
        Log.e("AAA", "onPreSave");
//        Log.e("User", user.toString());
        return restApi.saveUserById(id, user);
    }
}
