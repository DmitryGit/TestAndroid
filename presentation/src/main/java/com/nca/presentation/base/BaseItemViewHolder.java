package com.nca.presentation.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nca.testandroid.BR;

public abstract class BaseItemViewHolder<Model, ViewModel extends BaseItemViewModel, Binging extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private Binging binging;
    private ViewModel viewModel;

    public BaseItemViewHolder(Binging binging, ViewModel viewModel) {
        super(binging.getRoot());
        this.binging = binging;
        this.viewModel = viewModel;
        this.viewModel.init();
        initViewModel();

    }

    // пока не используется
    public ViewModel getViewModel() {
        return viewModel;
    }

    protected void initViewModel() {
        binging.setVariable(BR.viewModel, viewModel);
    }

    public void bindTo (Model model, int position) {
        this.viewModel.setItem(model, position);
        binging.executePendingBindings();
    }

    public void release() {
        this.viewModel.release();

    }
}
