package com.nca.testandroid.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.nca.testandroid.R;
import com.nca.testandroid.hw1.Homework1Activity;
import com.nca.testandroid.hw3.Homework3Activity;
import com.nca.testandroid.hw4.Homework4Activity;
import com.nca.testandroid.hw5.Homework5Activity;
import com.squareup.leakcanary.LeakCanary;

public class HomeworkMain extends Activity implements View.OnClickListener {

    private Button button_hw1;
    private Button button_hw2;
    private Button button_hw3;
    private Button button_hw4;
    private Button button_hw5;

    @Override
    public void onClick(View view) {

        Class<?> activity;

        switch(view.getId()) {
            case R.id.button_hw1:
                activity = Homework1Activity.class;
                break;
            case R.id.button_hw2:
                activity = Homework2Activity.class;
                break;
            case R.id.button_hw3:
                activity = Homework3Activity.class;
                break;
            case R.id.button_hw4:
                activity = Homework4Activity.class;
                break;
            case R.id.button_hw5:
                activity = Homework5Activity.class;
                break;
            default:
                activity = HomeworkMain.class;
        };

        Intent intent = new Intent(HomeworkMain.this, activity);
        startActivity(intent);
//        startActivityForResult(intent, CHOOSE_THIEF);
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
//        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.enableDisplayLeakActivity(this);

        setContentView(R.layout.activity_homework_main);

        button_hw1 = findViewById(R.id.button_hw1);
        button_hw2 = findViewById(R.id.button_hw2);
        button_hw3 = findViewById(R.id.button_hw3);
        button_hw4 = findViewById(R.id.button_hw4);
        button_hw5 = findViewById(R.id.button_hw5);

        button_hw1.setOnClickListener(this);
        button_hw2.setOnClickListener(this);
        button_hw3.setOnClickListener(this);
        button_hw4.setOnClickListener(this);
        button_hw5.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
}