package com.nca.presentation.screen.user.usermvp;

import com.nca.domain.entity.UserEntity;
import com.nca.presentation.base.BaseView;

public interface UserView extends BaseView{

    void showUser(UserEntity userEntity);
}
