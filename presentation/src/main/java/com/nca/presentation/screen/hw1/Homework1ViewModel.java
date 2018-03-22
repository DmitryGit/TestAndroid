package com.nca.presentation.screen.hw1;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.nca.data.repository.UserRepositoryImpl;
import com.nca.domain.entity.TwoStrings;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.executor.UIThread;
import com.nca.presentation.base.BaseViewModel;
import com.nca.testandroid.utils.MyAppGlideModule;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Homework1ViewModel extends BaseViewModel {

    public ObservableField<String> textView1 = new ObservableField<>("");
    public ObservableField<String> textView2 = new ObservableField<>("");

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void createInject() {
        // тут что-то нужно?
    }

    public void exchange(TextView tv1, TextView tv2) {
        String textView1Text = (String)tv1.getText();
        tv1.setText(tv2.getText());
        tv2.setText(textView1Text);
    }
    public Homework1ViewModel() {

//        Disposable disposable = Observable.create(new ObservableOnSubscribe<TwoStrings>() {
//            @Override
//            public void subscribe(ObservableEmitter<TwoStrings> emitter) throws Exception {
////                UserEntity userEntity = new UserEntity("super user", 20, "");
//                emitter.onNext(exchange());
//                emitter.onComplete();
//            }
//        });
    }

}
