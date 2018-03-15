package com.nca.testandroid.hw9;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.ImageView;

import com.nca.testandroid.utils.MyAppGlideModule;

public class User {

    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableField<String> fatherName = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();
    public ObservableField<String> imageUrl = new ObservableField<>("");

    public User(String firstName, String lastName, String fatherName, Integer age, boolean isMan, String imageURL) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.fatherName.set(fatherName);
        this.age.set(age);
        this.isMan.set(isMan);
        this.imageUrl.set(imageURL);
    }

//    @BindingAdapter({"bind:imageUrl"})
//    public static void loadImage(ImageView view, String url) {
////        Picasso.with(view.getContext()).load(url).error(error).into(view);
//        MyAppGlideModule.showImage(view.getContext(), url, view);
//    }

}
