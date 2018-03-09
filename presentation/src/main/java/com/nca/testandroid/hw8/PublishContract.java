package com.nca.testandroid.hw8;

import io.reactivex.Observable;

public interface PublishContract {

    // MMVM
    // MVP

//    PublishSubject<Integer> getPublishSubject();
    Observable<Long> getObservable();
}
