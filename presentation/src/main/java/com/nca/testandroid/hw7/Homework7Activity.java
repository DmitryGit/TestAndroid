package com.nca.testandroid.hw7;

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

import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

public class Homework7Activity extends AppCompatActivity {

    private View buttonFragment;

    PublishSubject<Integer> subject = PublishSubject.create();

    static Integer val = 0;

    private static final String TAG = Classwork1Activity.class.getSimpleName();
    private static final String SHARED_PREFS_NAME = "ffffff";
    private static final String KEY_NAME = "name";
    SharedPreferences sharedPreferences;

//    private View.OnClickListener listener = new View.OnClickListener(){
//
//        @Override
//        public void onClick(View view) {
//            changeFragment();
//
////            Intent intent = new Intent(Classwork7Activity.this, NextActivity.class);
////            intent.putExtra(NextActivity.KET_TEXT, "Hello");
////
////            startActivity(intent);
//
//            //finish();
//        }
//    };

    private void showFragment(Fragment fragment, boolean addBackStack) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_classwork7);
        super.onCreate(savedInstanceState);

//        subject.subscribe(v -> OneFragment.getInstance().addInt(v));


        buttonFragment = findViewById(R.id.buttonFragment);
        buttonFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                subject.onNext(val);
                val++;
                showFragment(OneFragment.getInstance(), true);

//            Intent intent = new Intent(Classwork7Activity.this, NextActivity.class);
//            intent.putExtra(NextActivity.KET_TEXT, "Hello");
//
//            startActivity(intent);

                //finish();
            }
        });

        // для того чтобы не перерисовывать фрагмент если он не удален или "забыт"
        if (savedInstanceState == null) {
            showFragment(OneFragment.getInstance(), false);

        }
    }
}

// БД - Realm, Room, ORMLite