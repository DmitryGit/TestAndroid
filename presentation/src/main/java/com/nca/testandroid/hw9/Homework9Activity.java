package com.nca.testandroid.hw9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityHomework9Binding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
public class Homework9Activity extends AppCompatActivity {

    private Disposable disposable;
    ActivityHomework9Binding binding;
    User user;
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(Homework9Activity.this, R.layout.activity_homework9);

        disposable = Observable
//                .timer(4, TimeUnit.SECONDS)
                .interval(5, TimeUnit.SECONDS)
                .map(new Function<Long, User>() {
                    @Override
                    public User apply(Long lon) throws Exception {
                        return users.get(lon.intValue());
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
        users.add(new User("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg"));
        users.add(new User("Варвара", "Краса", "длинная коса", 18, false, "http://tv.akado.ru/images/data/akadotv/picture/imgbig/468702/1.jpg"));
        users.add(new User("Словей", "Разбойник", "бандит", 100, true, "http://www.bestiary.us/files/images/solovey-by-orlova.250x250.jpg"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
