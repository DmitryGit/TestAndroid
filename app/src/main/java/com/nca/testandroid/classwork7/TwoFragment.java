package com.nca.testandroid.classwork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;

public class TwoFragment extends Fragment {

    public static TwoFragment getInstance() {
        return new TwoFragment();
    }

    private static final String KEY_VALUE = "KEY_VALUE";

//    public static TwoFragment getInstance(FragmentManager fragmentManager, int value) {
//        TwoFragment fragment = (TwoFragment) fragmentManager.findFragmentByTag(TwoFragment.class.getSimpleName());
//        if (fragment == null) {
//            fragment = new TwoFragment();
//        }
//
//        Bundle bundle = new Bundle();
//        bundle.putInt(KEY_VALUE, value);
//        fragment.setArguments(bundle);
//
//        return fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // все действия как и в активити onCreate - инициализация UI
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // доступ к активити и ее методам по ссылке
//        (Classwork7Activity)getActivity(). ..к примеру...onBackPressed();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Bundle bundle = getArguments();
//        if(bundle != null) {
//            int value = bundle.getInt(KEY_VALUE);
//        }
    }
}
