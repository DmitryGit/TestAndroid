package com.nca.testandroid.classwork8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;
import com.nca.testandroid.classwork7.OneFragment;
import com.nca.testandroid.classwork7.TwoFragment;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Classwork8Activity extends AppCompatActivity implements PublishContract {

    private View buttonFragment;

    private static final String TAG = Classwork1Activity.class.getSimpleName();

//    public PublishSubject<Integer> publishSubject = PublishSubject.create();
//    public BehaviorSubject<Integer> publishSubject = BehaviorSubject.create();
    public ReplaySubject<Integer> publishSubject = ReplaySubject.create();

    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_classwork8);

        super.onCreate(savedInstanceState);

        buttonFragment = findViewById(R.id.buttonFragment);
        buttonFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                publishSubject.onNext(count);
                count++;

            }
        });

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, com.nca.testandroid.classwork8.OneFragment.getInstance());
        fragmentTransaction.commit();


    }

    @Override
    public Observable<Integer> getObservable() {
        return publishSubject;
    }
}

// БД - Realm, Room, ORMLite