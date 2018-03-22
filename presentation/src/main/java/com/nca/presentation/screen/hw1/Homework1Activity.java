package com.nca.presentation.screen.hw1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityHomework9Binding;
import com.nca.testandroid.databinding.ActivityUserBinding;

public class Homework1Activity /*extends BaseMvvActivity<ActivityHomework1uBinding, Homework1ViewModel>  implements View.OnClickListener */{

//    @Override
//    public int provideLayoutId() {
//        return R.layout.activity_homework1u;
//    }
//
//    @Override
//    public Homework1ViewModel provideViewModel() {
//        return ViewModelProviders.of(this).get(Homework1ViewModel.class);
//    }
//
//
//    private Button button;
//    private TextView textView1;
//    private TextView textView2;
//
//    private View.OnClickListener listener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            exchange(textView1, textView2);
//        }
//    };
//
//    public void exchange(TextView tv1, TextView tv2) {
//        String textView1Text = (String)tv1.getText();
//        tv1.setText(tv2.getText());
//        tv2.setText(textView1Text);
//    }
//
//    // имплемент OnClickListener на текущую активити, привязку см. в xml файле
//    // как вариант можно textView1.setOnClickListener(this)
//    @Override
//    public void onClick(View v) {
//        exchange(textView1, textView2);
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_homework1);
//
//        button = findViewById(R.id.button);
//        textView1 = findViewById(R.id.textView1);
//        textView2 = findViewById(R.id.textView2);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                exchange(textView1, textView2);
//            }
//        });
//
//        textView2.setOnClickListener(listener);
//
//    }
    // Повесьте клик плиз 3-мя разными способами: сделать имплемент OnClickListener на текущую активити, анонимным классом прямо впихивая его в аргумент и в виде переменной отдельно как делали в классе.

}
