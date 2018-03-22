package com.nca.presentation.screen.hw2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nca.testandroid.R;

public class Homework2Activity extends AppCompatActivity {

    private Button button;
    private TextView textView1;
    private TextView textView2;

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework2);



    }


}
