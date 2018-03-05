package com.nca.testandroid.classwork9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityClasswork9Binding;

public class Classwork9Activity extends AppCompatActivity {

//    private static final String TAG = Classwork9Activity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_classwork9);

        ActivityClasswork9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork9);
        binding.setMyEntity(new MyEntity("Ура!", "Жу-жужу"));
    }

}
