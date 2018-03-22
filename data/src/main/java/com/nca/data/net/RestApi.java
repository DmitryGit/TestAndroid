package com.nca.data.net;

import com.nca.data.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/User")
    Observable<List<User>> loadUsers();

    @GET("data/User/{objectId}")
    Observable<User> loadUserById(@Path("objectId") String id);
}
