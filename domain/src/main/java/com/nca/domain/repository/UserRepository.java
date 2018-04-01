package com.nca.domain.repository;

import com.nca.domain.entity.UserEntity;
import com.nca.domain.entity.UserEntityHW11;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

//    Observable<UserEntity> get(String id);
//    Observable<List<UserEntity>> get();
    Observable<List<UserEntity>> getRoom();
//    Completable save();
    Completable remove();

    // откоментировать для домашки
    Observable<UserEntityHW11> get(String id);
    Observable<List<UserEntityHW11>> get();
    Completable save(String id, UserEntityHW11 user);
//    Completable remove();

}
