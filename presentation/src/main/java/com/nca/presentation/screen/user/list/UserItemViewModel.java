package com.nca.presentation.screen.user.list;

import android.databinding.ObservableField;

import com.nca.domain.entity.UserEntity;
import com.nca.domain.entity.UserEntityHW11;
import com.nca.presentation.base.BaseItemViewModel;

public class UserItemViewModel extends BaseItemViewModel<UserEntityHW11> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");

    @Override
    public void setItem(UserEntityHW11 userEntity, int position) {
        name.set(userEntity.getUsername());
        age.set(String.valueOf(userEntity.getAge()));
    }
}
