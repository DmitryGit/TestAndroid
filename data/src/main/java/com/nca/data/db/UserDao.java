package com.nca.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.nca.data.entity.User;

import java.util.List;


import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface UserDao {

    @Insert
    void insert(List<User> userList);

    @Query("select * from User")
    Flowable<List<User>> getAll();

    @Query("select * from User where id = :id limit 1")
    Flowable<List<User>> getById(String id);

    @Query("delete from User")
    void deleteAll();
}
