package com.nca.testandroid.hw8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;

public class Homework8Activity extends AppCompatActivity implements PublishContract {

    public ReplaySubject<Long> publishSubject = ReplaySubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_classwork8);

        super.onCreate(savedInstanceState);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, OneFragment.getInstance());
        fragmentTransaction.commit();


    }

    @Override
    public Observable<Long> getObservable() {
        return publishSubject;
    }
}

// БД - Realm, Room, ORMLite