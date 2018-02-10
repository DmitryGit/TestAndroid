package com.nca.testandroid.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.nca.testandroid.R;

public class Classwork2Activity extends Activity{

    private Button button1;
    private View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(Classwork2Activity.this, NextActivity.class);
            intent.putExtra(NextActivity.KET_TEXT, "Hello");

            startActivity(intent);

            //finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_classwork1);

        super.onCreate(savedInstanceState);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(listener);

        Singleton singleton = Singleton.getInstance();
        singleton.text = "dfgfd";

    }
}