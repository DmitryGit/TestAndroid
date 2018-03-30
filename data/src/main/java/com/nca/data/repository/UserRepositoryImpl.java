package com.nca.data.repository;

import android.content.Context;

import com.nca.data.db.AppDatabase;
import com.nca.data.db.UserDao;
import com.nca.data.entity.User;
import com.nca.data.net.RestService;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

//@Singleton
public class UserRepositoryImpl implements UserRepository {


    private Context context;
    private RestService restService;
    private UserDao userDao;
//    private long lastTimeUpdate;

    public UserRepositoryImpl(Context context, RestService restService, AppDatabase database) {
        this.context = context;
        this.restService = restService;
        this.userDao = database.getUserDao();
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

    @Override
    public Observable<List<UserEntity>> getRoom() {
        return
//                userDao
//                .getAll()
//                .flatMap(new Function<List<User>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(List<User> users) throws Exception {
//                        if(users!= null && users.size() > 0 && lastTimeUpdate ) { // недоделано хотели проверку на время
//                        return Observable.just(users);
//                    }
//                })

            restService
                .loadUsers()
//                .toFlowable(BackpressureStrategy.DROP)
                .doOnNext(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        userDao.deleteAll();
                        userDao.insert(users);
                    }
                })
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<User>>>() {
                    @Override
                    public ObservableSource<? extends List<User>> apply(Throwable throwable) throws Exception {
                        return userDao.getAll().take(1).toObservable();
                    }
                })
                .map(new Function<List<User>, List<UserEntity>>() {
                    @Override
                    public List<UserEntity> apply(List<User> users) throws Exception {
                        List<UserEntity> userEntities = new ArrayList<>();

                        for (User user : users) {
                            userEntities.add(new UserEntity(user.getUsername(), user.getUsername(), user.getUsername(), user.getAge(), true, user.getProfileUrl()));
                        }
                        return userEntities;
                    }
                });
    }


}
