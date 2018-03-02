package com.nca.testandroid.classwork8;

import android.app.Activity;
import android.content.Context;
import android.icu.util.TimeUnit;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nca.testandroid.R;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class OneFragment extends Fragment {

    private TextView textView;
    private PublishContract publishContract;
    private Observable observable;
    private Disposable disposable;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one_cw8, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // все действия как и в активити onCreate - инициализация UI
        textView = view.findViewById(R.id.textView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });



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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity != null) {
            publishContract = (PublishContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }

    private void subscribe() {

        disposable = publishContract
                .getObservable()
//                .timeout(1, TimeUnit.SECOND)
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer % 10 == 0;
//                    }
//                })
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        // здесь можно что-то сделать в промежутке
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })
                //.flatMap // получить изменения из БД или чего-то похожего - например List<User>
//                .take(5) // получить один (или сколько надо) результат
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        // здесь можно что-то сделать в промежутке
                    }
                })
                .subscribe( new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        // сюда прилетают данные
                        textView.setText(String.valueOf(string));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // сюда прилетают ошибки
                    }

                })
//                .subscribe( new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        // сюда прилетают данные
//                        textView.setText(String.valueOf(integer));
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        // сюда прилетают ошибки
//                    }
//
//                })
        ;

    }

}
