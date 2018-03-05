package com.nca.testandroid.classwork9;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

public class MyEntity {

//    public String text;
//    public String textButton;
//    public boolean buttonVisible = false;
    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<String> textButton = new ObservableField<>("");
    public ObservableBoolean buttonVisible = new ObservableBoolean(true);

    public MyEntity(String text, String textButton) {
        this.text.set(text);
        this.textButton.set(textButton);
//        this.text = text;
//        this.textButton = textButton;
    }

    public  void buttonClick(View view) {
        Log.e("AAA", "Button click");
        buttonVisible.set(false);
    }
}
