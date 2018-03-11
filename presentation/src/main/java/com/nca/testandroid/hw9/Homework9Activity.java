package com.nca.testandroid.hw9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityHomework9Binding;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
public class Homework9Activity extends AppCompatActivity {

    public PublishSubject<Integer> publishSubject = PublishSubject.create();
    private Disposable disposable;
    ActivityHomework9Binding binding;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(Homework9Activity.this, R.layout.activity_homework9);

        disposable = publishSubject
                .timer(4, TimeUnit.SECONDS)
                .map(new Function<Long, User>() {
                    @Override
                    public User apply(Long lon) throws Exception {
                        return user;
                    }
                })
                .subscribe( new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        binding.setUser(user);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // сюда прилетают ошибки
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = new User("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg");
        publishSubject.just(user);
//        user = new User("Олег", "3333", "Неизвестно", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg");
//        publishSubject.just(user);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
