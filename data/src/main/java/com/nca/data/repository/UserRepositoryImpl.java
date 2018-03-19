package com.nca.data.repository;

import android.content.Context;

import com.nca.data.entity.User;
import com.nca.data.net.RestService;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository {


    private Context context;
    private RestService restService;

    public UserRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }
//    public UserRepositoryImpl(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public Observable<UserEntity> get(String id) {
//        return Observable.create(new ObservableOnSubscribe<UserEntity>() {
//            @Override
//            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                Thread.sleep(5000);
//                UserEntity userEntity = new UserEntity("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg");
//
//                emitter.onNext(userEntity);
//                emitter.onComplete();
//            }
//        });
//    }

    @Override
    public Observable<UserEntity> get(String id) {
        return restService
                .loadUserById(id)
                .map(new Function<User, UserEntity>() {
                    @Override
                    public UserEntity apply(User user) throws Exception {
                        return new UserEntity(user.getUsername(), user.getUsername(), user.getUsername(), user.getAge(), true,  user.getProfileUrl());
                    }
                });

    }

    @Override
    public Observable<List<UserEntity>> get() {
        return restService
                .loadUsers()
                .map(new Function<List<User>, List<UserEntity>>() {
                    @Override
                    public List<UserEntity> apply(List<User> users) throws Exception {
                        List<UserEntity> userEntities = new ArrayList<>();

                        for (User user: users) {
                            userEntities.add(new UserEntity(user.getUsername(), user.getUsername(), user.getUsername(), user.getAge(), true,  user.getProfileUrl()));
                        }
                        return userEntities;
                    }
                });
    }

    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
