package com.nca.testandroid.hw4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nca.testandroid.BuildConfig;
import com.nca.testandroid.R;
import com.nca.testandroid.utils.MyAppGlideModule;

public class Homework4Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageOwl;
    private View viewWatch;
    AnimationDrawable frameAnimation;

    private TextView textView9;
    private TextView textView12;
    private TextView textView3;
    private TextView textView6;

    @Override
    public void onClick(View v) {
        viewWatch = findViewById(R.id.viewWatch);
        frameAnimation.stop();
        imageOwl.setVisibility(View.GONE);
        viewWatch.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4  );

        imageOwl = findViewById(R.id.imageOwl);
        imageOwl.setOnClickListener(this);
        imageOwl.setBackgroundResource(R.drawable.owl);
        frameAnimation = (AnimationDrawable) imageOwl.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();

        textView9 = findViewById(R.id.d9);
        textView12 = findViewById(R.id.d12);
        textView3 = findViewById(R.id.d3);
        textView6 = findViewById(R.id.d6);
    }
}
