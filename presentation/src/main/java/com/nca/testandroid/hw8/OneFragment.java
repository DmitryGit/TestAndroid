package com.nca.testandroid.hw8;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nca.testandroid.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.ReplaySubject;

public class OneFragment extends Fragment {

    private TextView textView;
    private Disposable disposable;
    String textViewValue;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one_hw8, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // все действия как и в активити onCreate - инициализация UI
        textView = view.findViewById(R.id.textView);
        textView.setText("Запускаем...");
        disposable = Observable
                .interval(2, TimeUnit.SECONDS)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long lon) throws Exception {
                        return lon.intValue();
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer.toString();
                    }
                })
                .subscribe( new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        setTextView(string);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                       throwable.getCause(); // сюда прилетают ошибки
                    }
                })
        ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private void setTextView(String s) {

        textViewValue = s;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(textViewValue);
            }
        });

    }
}
