package com.nca.presentation.screen.user.list;

import android.view.ViewGroup;

import com.nca.domain.entity.UserEntityHW11;
import com.nca.presentation.base.BaseAdapter;


public class UserAdapter extends BaseAdapter<UserEntityHW11, UserItemViewModel> {

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
