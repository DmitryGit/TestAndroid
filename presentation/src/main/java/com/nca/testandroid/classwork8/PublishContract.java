package com.nca.testandroid.classwork8;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public interface PublishContract {

    // MMVM
    // MVP

//    PublishSubject<Integer> getPublishSubject();
    Observable<Integer> getObservable();
}
