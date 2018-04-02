package com.nca.presentation.screen.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nca.domain.entity.UserEntityHW11;
import com.nca.presentation.base.BaseItemViewHolder;
import com.nca.testandroid.databinding.ItemUserCw14Binding;


public class UserItemViewHolder extends BaseItemViewHolder<UserEntityHW11, UserItemViewModel, ItemUserCw14Binding> {

    public UserItemViewHolder(ItemUserCw14Binding itemUserCw14Binding, UserItemViewModel viewModel) {
        super(itemUserCw14Binding, viewModel);
    }

    public static UserItemViewHolder create(ViewGroup parent, UserItemViewModel viewModel) {

        ItemUserCw14Binding binding = ItemUserCw14Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserItemViewHolder(binding, viewModel);

    }
}
