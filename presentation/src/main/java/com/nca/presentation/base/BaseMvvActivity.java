package com.nca.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.nca.domain.entity.UserEntityHW11;
import com.nca.testandroid.BR;

public abstract class BaseMvvActivity<Binding extends ViewDataBinding, ViewModel extends BaseViewModel> extends AppCompatActivity {

    protected Binding binding;
    protected ViewModel viewModel;

//    @Nullable
//    protected R router;

    public abstract int provideLayoutId();
    public abstract ViewModel provideViewModel();
//    public abstract R provideRouter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = provideViewModel();
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel, viewModel);

//        router = provideRouter();
//        viewModel.attachRouter(router);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }
    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        router = null;
        viewModel.detachRouter();
    }
}
