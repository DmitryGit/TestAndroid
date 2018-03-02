package com.nca.testandroid.classwork7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;
import com.nca.testandroid.classwork2.NextActivity;
import com.nca.testandroid.classwork2.Singleton;

public class Classwork7Activity extends AppCompatActivity {

    private View buttonFragment;
    private boolean isOneVisible = true;

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

    private void changeFragment() {
        if(isOneVisible) {
            // первый вариант, второй с передачей данных для фрагменов при их "удалении" закоментрванно в TwoFragment.getInstance()
            showFragment(TwoFragment.getInstance(), true);
            isOneVisible = false;
        } else {
            showFragment(OneFragment.getInstance(),true);
            isOneVisible = true;
        }
    }

    private void showFragment(Fragment fragment, boolean addBackStack) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

   //----------вариация 2 -------------
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addBackStack) {
            // для добавлеия в бэкстек
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }

//-------------------------

//        fragmentTransaction.replace(R.id.container, fragment);
//        if (addBackStack) {
//            // для добавлеия в бэкстек
//            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
//        }

        // сюда можно добавить анимацию
        //....
        fragmentTransaction.commit();



    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_classwork7);

        super.onCreate(savedInstanceState);

        buttonFragment = findViewById(R.id.buttonFragment);
        buttonFragment.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                changeFragment();

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

        // там где массивные данные?
        getFilesDir();
        // отдельные хранилища
        getExternalFilesDir("ddd");
        // кешитрованные файлы
        getCacheDir();


        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString(KEY_NAME, "");
        Log.e("AAA", "text = " + text);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit()
                .putString(KEY_NAME, "Hello")
                .apply();

    }
}

// БД - Realm, Room, ORMLite