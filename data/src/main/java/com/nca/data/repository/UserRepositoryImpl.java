package com.nca.data.repository;

import com.nca.domain.entity.UserEntity;
import com.nca.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Observable<UserEntity> get(String id) {
        return Observable.create(new ObservableOnSubscribe<UserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
                Thread.sleep(5000);
                UserEntity userEntity = new UserEntity("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg");

                emitter.onNext(userEntity);
                emitter.onComplete();
            }
        });
    }

    @Override
    public Observable<List<UserEntity>> get() {
        return null;
//        return Observable.just(new ArrayList<UserEntity>());
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
