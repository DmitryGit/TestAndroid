package com.nca.presentation.screen.user;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import com.nca.app.App;
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

public class UserViewModelForHome9 extends BaseViewModel {

//    GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(new UIThread());

    @Override
    public void createInject() {
//        App.getAppComponent().inject(this);
    }


    public ObservableInt background = new ObservableInt(Color.WHITE);

    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableField<String> fatherName = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();
    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    private ArrayList<UserEntity> users = new ArrayList<>();

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        MyAppGlideModule.showImage(view.getContext(), url, view);
    }

    public UserViewModelForHome9() {

            users.add(new UserEntity("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg"));
            users.add(new UserEntity("Варвара", "Краса", "длинная коса", 18, false, "http://tv.akado.ru/images/data/akadotv/picture/imgbig/468702/1.jpg"));
            users.add(new UserEntity("Словей", "Разбойник", "бандит", 100, true, "http://www.bestiary.us/files/images/solovey-by-orlova.250x250.jpg"));


            progressVisible.set(true);
        Observable.create(new ObservableOnSubscribe<UserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                UserEntity userEntity = new UserEntity("super user", 20, "");
                for (UserEntity userEntity: users) {
                    progressVisible.set(true);
                    Thread.sleep(4000);
                    if (userEntity.isMan()) {
                        background.set(0xFF1190E9);
                    } else {
                        background.set(Color.MAGENTA);
                    }
                    emitter.onNext(users.get(users.indexOf(userEntity)));
                }
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "onSubscribe");
                        compositeDisposable.add(d);
                    }

            @Override
            public void onNext(UserEntity userEntity) {
                Log.e("AAA", "onNext");
                firstName.set(userEntity.getFirstName());
                lastName.set(userEntity.getLastName());
                fatherName.set(userEntity.getFatherName());
                age.set(userEntity.getAge());
                isMan.set(userEntity.isMan());
                imageUrl.set(userEntity.getImageUrl());
            }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "onComplete");
                        progressVisible.set(false);
                    }
                })
        ;
    }

}
