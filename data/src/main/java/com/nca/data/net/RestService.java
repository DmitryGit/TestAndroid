package com.nca.data.net;

import com.nca.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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
        return restApi.loadUsers();
    }

//    @Override
    public Observable<User> loadUserById(String id) {
        return restApi.loadUserById(id);
    }
}
