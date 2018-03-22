package com.nca.domain.interactors;

import android.graphics.Color;

import com.nca.domain.entity.UserEntity;
import com.nca.domain.executor.PostExecutionThread;
import com.nca.domain.executor.ThreadExecutor;
import com.nca.domain.repository.UserRepository;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class GetUserByIdUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread,
                              @Named("rep1") UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id) {
                return userRepository.get(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

    public Observable<List<UserEntity>> get() {
                return userRepository.get()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

//        return Observable.create(new ObservableOnSubscribe<UserEntity>() {
//        @Override
//        public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//            Thread.sleep(5000);
//            UserEntity userEntity = new UserEntity("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg");
//
//            emitter.onNext(userEntity);
//            emitter.onComplete();
//        }
//    })
//            .subscribeOn(threadExecution)
//                .observeOn(postExecutionThread);
//}

}
