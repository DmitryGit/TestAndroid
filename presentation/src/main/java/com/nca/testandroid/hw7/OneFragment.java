package com.nca.testandroid.hw7;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nca.testandroid.R;
import com.nca.testandroid.hw4.Homework4Activity;
import com.nca.testandroid.hw6.Homework6Activity;

import io.reactivex.Observer;

public class OneFragment extends Fragment {

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // все действия как и в активити onCreate - инициализация UI
        TextView textView = view.findViewById(R.id.integer);
        textView.setText(String.valueOf(Homework7Activity.val));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
