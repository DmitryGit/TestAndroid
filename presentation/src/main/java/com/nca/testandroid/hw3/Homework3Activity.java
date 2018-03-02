package com.nca.testandroid.hw3;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nca.testandroid.BuildConfig;
import com.nca.testandroid.R;
import com.nca.testandroid.utils.MyAppGlideModule;

public class Homework3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView textView;
    private ImageView imageView;
    private Button button;

    @Override
    public void onClick(View v) {
        MyAppGlideModule.showImage(this, editText.getText().toString(), imageView);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        button = findViewById(R.id.buttonLoadImage);
        button.setOnClickListener(this);

        textView = findViewById(R.id.textView);
        textView.setText(BuildConfig.API_ENDPOINT);

        imageView = findViewById(R.id.imageView);

        editText = findViewById(R.id.editText);

    }

}
